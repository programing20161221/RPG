package rpg;

import java.io.IOException;

public class Showparty implements Icommand{
	Text name = new Text();
	Input input = new Input();

	@Override
	public String showname() {
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
		for(int i = 0; i < Main.party.ch.size(); i++){
			System.out.println((i+1) + "." + Main.party.ch.get(i).getName());
		}
		return null;
	}

}
