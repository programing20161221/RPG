package rpg;

import java.io.IOException;

public class Deviaparty implements Icommand{
	Text name = new Text();
	Input input = new Input();

	@Override
	public String show() {
		// TODO Auto-generated method stub
		name.setvalue("パーティから外れる．");
		return name.getvalue();
	}

	@Override
	public Dialog action() throws IOException {
		// TODO Auto-generated method stub
		int key;

		if(Main.party.ch.size() == 0){
			System.out.println("キャラクターはいません．");
			return null;
		}

		System.out.println("パーティから外すキャラクターを選択してください．");
		Main.party.showParty();
		System.out.println((Main.party.ch.size()+1) + ".戻る");

		key = input.getInt()-1;

		if(key >= 0 && key < Main.party.ch.size())
			Main.party.ch.remove(key);
		return null;
	}

}
