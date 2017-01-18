package rpg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	static Dialog dialog;
	static Dialog tmp;
	static ArrayList<Character> ch = new ArrayList<Character>();
	static Party party = new Party();

	static void init() {
		Dialog title = new Dialog();
		Dialog town = new Dialog();
		Dialog field = new Dialog();
		Dialog tavern = new Dialog();

		CmdBattle battle  = new CmdBattle();

		tmp = new Dialog();

		newcharacter newchara = new newcharacter();
		deletecharacter delchara = new deletecharacter();
		Enterparty enterparty = new Enterparty();
		Showparty showparty = new Showparty();
		Deviaparty deviateparty = new Deviaparty();
		Checkcharacter checkcharacter = new Checkcharacter();


		CmdMove gamestart = new CmdMove("GAMESTART", town);
		CmdMove tofield = new CmdMove("外へ", field);
		CmdMove totown = new CmdMove("街へ戻る", town);
		CmdMove totitle = new CmdMove("タイトルへ戻る", title);
		CmdMove totavern = new CmdMove("酒場へ", tavern);

		title.set("タイトル", gamestart);
		town.set("街にいます", totavern, tofield, totitle);
//		town.setMessage("街にいます");
		field.setMessage("フィールドに出ました");
		tavern.setMessage("酒場にいます");
//
//		title.addcommand(gamestart);
//		town.addcommand(totavern);
//		town.addcommand(tofield);
//		town.addcommand(totitle);
		tavern.addcommand(totown);
		field.addcommand(totown);

		field.addcommand(battle);

		tavern.addcommand(newchara);
		tavern.addcommand(delchara);
		tavern.addcommand(enterparty);
		tavern.addcommand(showparty);
		tavern.addcommand(deviateparty);
		tavern.addcommand(checkcharacter);

		dialog = title;
	}

	public static boolean isNumber(String s) {
	    return Pattern.compile("^-?[0-9]+$").matcher(s).find();
	}

	public static int ReadException(String str){
		if(!isNumber(str)){
			System.out.println("Caution!:数字を入力してください．");
			return -1;
		}

		int key = Integer.parseInt(str);
		if(!(key <= dialog.cmdSize() && key > 0)){
			System.out.println("Caution!:出力された数値内での入力にしてください");
			return -1;
		}
		return key;
	}


	public static void main(String[] args) throws IOException {
//		 TODO Auto-generated method stub
//		InputStreamReader is = new InputStreamReader(System.in);
//		BufferedReader br = new BufferedReader(is);
//		Input input = new Input();
//		int key;
		
		Mage mage = new Mage();
		Priest priest = new Priest();
		Fighter fighter = new Fighter();
		Ranger ranger = new Ranger();
		Character chTest[] = new Character[4];
		
		chTest[0] = new Character();
		chTest[0].setName("ch1");
		chTest[0].setJob(mage);
		ch.add(chTest[0]);
		chTest[1] = new Character();
		chTest[1].setName("ch2");
		chTest[1].setJob(priest);
		ch.add(chTest[1]);
		chTest[2] = new Character();
		chTest[2].setName("ch3");
		chTest[2].setJob(fighter);
		ch.add(chTest[2]);
		chTest[3] = new Character();
		chTest[3].setName("ch4");
		chTest[3].setJob(ranger);
		ch.add(chTest[3]);
		
		party.addparty(chTest[0]);
		party.addparty(chTest[1]);
		party.addparty(chTest[2]);
		party.addparty(chTest[3]);
		
		init();

		while (true) {
			dialog.showmessage(); //説明文
			dialog.show(); //コマンド一覧

			System.out.println(" > ");

			Scanner scan = new Scanner(System.in);
			int key;
			if((key = ReadException(scan.next())) == -1)
				continue;
			tmp = dialog.Caction(dialog, key);
			dialog = (tmp != null)? tmp :dialog; //実行 → 次の状態
			/*
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
			*/
		}
	}

}
