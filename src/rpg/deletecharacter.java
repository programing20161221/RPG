package rpg;

import java.io.IOException;

public class deletecharacter implements Icommand{
	Text name = new Text();
	Input input = new Input();
	
	@Override
	public String showname() {
		// TODO Auto-generated method stub
		name.setvalue("キャラクターの削除");
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
		
		System.out.println("削除するキャラクターを選択してください．");
		Main.ch.get(1).showCharacter();
		System.out.println((Main.ch.size()+1) + ".戻る");
		
		key = input.getint()-1;
		if(key >= 0 && key < Main.ch.size()){
			Main.ch.remove(key);
		}
		return null;
	}
}
