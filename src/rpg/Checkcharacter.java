package rpg;

import java.io.IOException;

public class Checkcharacter implements Icommand{
	Text name = new Text();
	Input input = new Input();
	
	@Override
	public String showname() {
		// TODO Auto-generated method stub
		name.setvalue("キャラクターを確認する");
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
		
		System.out.println("確認するキャラクターを選択してください．");
		for(int i = 0; i < Main.ch.size(); i++){
			System.out.println((i+1) + "." + Main.ch.get(i).getName());
		}
		System.out.println((Main.ch.size()+1) + ".戻る");
		
		key = input.getint()-1;
		if(key >= 0 && key < Main.ch.size())
			Main.ch.get(key).getstatus();
		
		return null;
	}
}
