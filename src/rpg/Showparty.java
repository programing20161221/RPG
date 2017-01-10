package rpg;

import java.io.IOException;

public class Showparty implements Icommand{
	Text name = new Text();
	Input input = new Input();

	@Override
	public String showname() {
		// TODO Auto-generated method stub
		name.setvalue("パーティを確認する．");
		return name.getvalue();
	}

	@Override
	public Dialog action() throws IOException {
		// TODO Auto-generated method stub
		if(Main.party.ch.size() == 0){
			System.out.println("キャラクターはいません．");
			return null;
		}
		
		System.out.println("現在のパーティメンバー：");
		Main.showparty();
		return null;
	}

}
