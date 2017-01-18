package rpg;

import java.io.IOException;

public class Enterparty implements Icommand{
	Text name = new Text();
	Input input = new Input();

	@Override
	public String show() {
		// TODO Auto-generated method stub
		name.setvalue("パーティに入れる．");
		return name.getvalue();
	}

	@Override
	public Dialog action() throws IOException {
		// TODO Auto-generated method stub
		int key;

		if(Main.ch.size() == 0){
			System.out.println("キャラクターはいません．");
			return null;
		}

		System.out.println("パーティに入れるキャラクターを選択してください．");
		Main.ch.get(1).showCharacter();
		System.out.println((Main.ch.size()+1) + ".戻る");

		key = input.getInt()-1;
		if(key >= 0 && key < Main.ch.size()){
			Main.party.ch.add(Main.ch.get(key));
		}
		return null;
	}

}
