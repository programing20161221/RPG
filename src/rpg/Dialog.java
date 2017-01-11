package rpg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Dialog {
	Text message = new Text();
	ArrayList<CmdMove> commandL = new ArrayList<CmdMove>();
	ArrayList<Icommand> commandI = new ArrayList<Icommand>();

	// 外部入力用の変数
	InputStreamReader is = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(is);

	public Text getMessage() {return message;}
	public void setMessage(String message) { this.message.setvalue(message);}
	void setmessage(String text) { this.message.setValue(text);}
	
	void show() {
		System.out.println(message.showvalue());
		for (int i = 0; i < commandL.size(); i++) {
			System.out.println((i + 1) + "." + commandL.get(i).show());
		}
	}

	void showmessage() {
		System.out.println(this.message.showvalue());
	}

	Dialog input(int key) {
		return commandL.get(key).action();
	}

	void addcomaand(CmdMove command) {
		commandL.add(command);
	}

	void addcommandI(Icommand command) {
		commandI.add(command);
	}


	void addcommand(Icommand cmd) {
		this.commandI.add(cmd);
	}

	void set(String text, Icommand... cmd) {
		setmessage(text);
		for (Icommand c : cmd)
			addcommand(c);
	}

	Dialog Caction(Dialog current, int key) {
		return commandL.get(key - 1).action();
	}
	int cmdSize(){
		return commandL.size();
	}
}
