package rpg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static Dialog dialog;
	static ArrayList<Character> ch = new ArrayList<Character>();
	static Party party = new Party();

	static void init() {
		Dialog title = new Dialog();
		Dialog town = new Dialog();
		Dialog field = new Dialog();
		Dialog tavern = new Dialog();
		newcharacter newchara = new newcharacter();
		deletecharacter delchara = new deletecharacter();
		Enterparty enterparty = new Enterparty();
		Showparty showparty = new Showparty();
		Deviaparty deviateparty = new Deviaparty();
		Checkcharacter checkcharacter = new Checkcharacter();

		title.setMessage("タイトル");
		town.setMessage("街にいます");
		field.setMessage("フィールドに出ました");
		tavern.setMessage("酒場にいます");

		CmdMove gamestart = new CmdMove();
		gamestart.settext("GAMESTART");
		gamestart.setdialog(town);

		CmdMove tofield = new CmdMove();
		tofield.settext("外へ");
		tofield.setdialog(field);

		CmdMove totown = new CmdMove();
		totown.settext("街へ戻る");
		totown.setdialog(town);

		CmdMove totitle = new CmdMove();
		totitle.settext("タイトルへ戻る");
		totitle.setdialog(title);

		CmdMove totavern = new CmdMove();
		totavern.settext("酒場へ");
		totavern.setdialog(tavern);

		title.addcomaand(gamestart);
		town.addcomaand(totavern);
		town.addcomaand(tofield);
		town.addcomaand(totitle);
		tavern.addcomaand(totown);
		field.addcomaand(totown);

		tavern.addcommandI(newchara);
		tavern.addcommandI(delchara);
		tavern.addcommandI(enterparty);
		tavern.addcommandI(showparty);
		tavern.addcommandI(deviateparty);
		tavern.addcommandI(checkcharacter);

		dialog = title;
	}
	
	public static void showcharacter(){
		for(int i = 0; i < ch.size(); i++){
			System.out.println((i+1) + "." + ch.get(i).getName());
		}
	}
	
	public static void showparty(){
		for(int i = 0; i < party.ch.size(); i++){
			System.out.println((i+1) + "." + party.ch.get(i).getName());
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		Input input = new Input();
		int key;

		init();

		while (true) {
			dialog.show();
			dialog = dialog.input(Integer.parseInt(br.readLine()) - 1);
			while (dialog.commandI.size() != 0) {
				System.out.println("何をしますか");
				for(int i = 0; i < dialog.commandI.size(); i++){
					System.out.println((i+1) + "." + dialog.commandI.get(i).showname());
				}
				System.out.println(dialog.commandI.size() + 1 + ".ここを出る");
				if (dialog.commandI.size() != (key = input.getint()-1)){
					dialog.commandI.get(key).action();
				}
				else
					break;
			}


		}
	}
	
}
