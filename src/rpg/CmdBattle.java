package rpg;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CmdBattle implements Icommand{

	private Text Choice_message;
	private Dialog dialog;

	private Fight fight;
	private UseItem item;
	private Escape escape;

	private Party party;
	private Monster m;
	private ArrayList<Bcommand> Blist = new ArrayList<Bcommand>();

	CmdBattle(Party p){
		this.Choice_message = new Text();
		this.dialog = new Dialog();

		this.m = new Monster("スライム");
//		m.setName("スライム");
//		m.setHp(10);
		this.party = p;

		settext("敵とたたかう");

		this.fight = new Fight(m, party);
		fight.settext("たたかう");
		this.item = new UseItem();
		item.settext("アイテムを使う");
		this.escape = new Escape();
		escape.set("にげる", null);

		Blist.add(fight);
		Blist.add(item);
		Blist.add(escape);

		dialog.set(m.getName()+"("+m.getHp()+"/"+m.getMaxhp()+")"+"があらわれた!!", fight, item, escape);
	}

	void set(String message, Dialog dialog){
		settext(message);
		setdialog(dialog);
	}

	void settext(String text){ this.Choice_message.setvalue(text);}
	void setdialog(Dialog dialog){ this.dialog = dialog;}
	Dialog getDialog(){ return this.dialog;}

	public String show(){
		return Choice_message.getvalue();
	}

	public Dialog action() throws IOException{
		dialog.showmessage();
		System.out.println("");

		while(true){
			System.out.println(party.printPartystatus());
			for(int i=1; i<= party.sizeParty() ;i++){
				dialog.setMessage(Main.party.ch.get(i-1).getName()+"は何をする?");
				dialog.showmessage(); //説明文
				dialog.Bshow(); //コマンド一覧

				System.out.print(" > ");

				Scanner scan = new Scanner(System.in);
				int key = Integer.parseInt(scan.next());
				Main.party.ch.get(i-1).setBcommand(Blist.get(key-1));

			}
			this.exec();
		}
	}

	public Dialog exec() throws IOException{
		for(int i=0; i< party.sizeParty() ;i++){
			party.getMember(i).getBcommand().action(party.getMember(i));
		}
		//monster
		Character ch = party.RandomMember();
		System.out.println("敵からの攻撃!\n"+ch.getName()+"が"+ m.getAttack()+"のダメージを食らった!!");
		ch.setHp(ch.getHp()- m.getAttack());
		System.out.println(ch.getName()+": ("+ch.getHp()+"/"+ch.getMaxhp()+")\n");
		System.out.println(m.getName()+"("+m.getHp()+"/"+m.getMaxhp()+")");
		return dialog;
	}

}
