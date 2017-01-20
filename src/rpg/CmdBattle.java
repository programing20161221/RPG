package rpg;
import java.io.IOException;
import java.util.Scanner;

public class CmdBattle implements Icommand{

	private Text Choice_message;
	private Dialog dialog;

	private Fight fight;
	private UseItem item;
	private CmdMove escape;

	private Party party;

	CmdBattle(Party p){
		this.Choice_message = new Text();
		this.dialog = new Dialog();

		this.party = p;

		settext("敵とたたかう");

		this.fight = new Fight();
		fight.settext("たたかう");
		this.item = new UseItem();
		item.settext("アイテムを使う");
		this.escape = new CmdMove();
		escape.set("にげる", null);
		dialog.set("Monster"+"があらわれた!!", fight, item, escape);
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
		while(true){

			for(int i=1; i<= party.sizeParty() ;i++){
//				Main.party.ch.get(i).getName()
				dialog.setMessage(Main.party.ch.get(i-1).getName()+"は何をする?");
				System.out.println("i:"+i);
				dialog.showmessage(); //説明文
				dialog.show(); //コマンド一覧

				System.out.println(" > ");

				Scanner scan = new Scanner(System.in);
				int key = Integer.parseInt(scan.next());
				if(key == 3){
					break;
				}

//				dialog.Caction(dialog, key);//あらかじめメンバーの行動を決めて，最後に実行
			}

		}
//		return null;
	}

}
