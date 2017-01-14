package rpg;

import java.io.IOException;

public class Showparty implements Icommand{
	Text name = new Text();
	Input input = new Input();

	@Override
	public String show() {
		name.setvalue("パーティを確認する．");
		return name.getvalue();
	}

	@Override
	public Dialog action() throws IOException {
		if(Main.party.ch.size() == 0){
			System.out.println("キャラクターはいません．");
			return null;
		}

		System.out.println("現在のパーティメンバー：");
		Main.party.showParty();
		return null;
	}

}
