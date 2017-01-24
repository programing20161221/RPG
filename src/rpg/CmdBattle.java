package rpg;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CmdBattle implements Icommand{

	private Text Choice_message;
	private Dialog dialog;
	private Dialog ret;
	private Fight fight;
	private UseItem item;
	private Escape escape;
	private int btl;
	private Party party;
	private Monster m;
	private ArrayList<Bcommand> Blist = new ArrayList<Bcommand>();

	CmdBattle(Party p, Dialog d){
		this.Choice_message = new Text();
		this.dialog = new Dialog();
		this.ret = d;
		this.m = new Monster("スライム");
		m.setAttack(30);
//		m.setName("スライム");
//		m.setHp(10);
		this.party = p;
		this.btl = party.sizeParty();
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
		btl =  party.liveMember()+1;
		while(m.getLive() && btl > 0){
			System.out.println(party.printPartystatus());
			for(int i=0; i< party.sizeParty() ;i++){
				Character c = Main.party.ch.get(i);
				if(!(c.getLive())){
					btl--;
					c.setBcommand(null);
					continue;
				}
				dialog.setMessage(c.getName()+"は何をする?");
				dialog.showmessage(); //説明文
				dialog.Bshow(); //コマンド一覧

				System.out.print(" > ");

				Scanner scan = new Scanner(System.in);
				int key = Integer.parseInt(scan.next());
				c.setBcommand(Blist.get(key-1));

			}
			this.exec();
		}
		if(btl <= 0){
			System.out.println("冒険者は負けてしまった!");
			return ret;
		}
		System.out.println(m.getName()+"を倒した!\n\n");
		getExp();
		return ret;
	}

	public void getExp(){
		System.out.println(""+ m.getEXP());
		int exp = m.getEXP()/party.sizeParty();
		System.out.println("パーティは"+exp+"[EXP]を手にいれた！");
		for(int i=0; i< party.sizeParty() ;i++){
			Main.party.ch.get(i).setEXP(exp);
		}
	}

	public int exec() throws IOException{
		for(int i=0; i< party.sizeParty() ;i++){
			if(!(m.getLive())) return 1;
			if(party.getMember(i).getBcommand()==null){
				continue;
			}
			party.getMember(i).getBcommand().action(party.getMember(i));
			if(m.getHp()<=0) m.setLive(false);
		}
		//monster
		Character ch = party.RandomMember();
		System.out.println("敵からの攻撃!\n"+ch.getName()+"が"+ m.getAttack()+"のダメージを食らった!!");
		ch.setHp(ch.getHp()- m.getAttack());
		if(ch.getHp() <= 0) ch.setLive(false);
		System.out.println(ch.getName()+": ("+ch.getHp()+"/"+ch.getMaxhp()+")\n");
		System.out.println(m.getName()+"("+m.getHp()+"/"+m.getMaxhp()+")");
		return 0;
	}

}
