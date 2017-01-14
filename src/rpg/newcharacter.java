package rpg;

import java.io.IOException;

public class newcharacter implements Icommand{
	Text name = new Text();
	Input input = new Input();
	Dialog returndialog  = new Dialog();

	@Override
	public String show() {
		// TODO Auto-generated method stub
		name.setvalue("新規キャラクターの作成");
		return name.getvalue();
	}

	@Override
	public Dialog action() throws IOException{
		// TODO Auto-generated method stub
		Character newchara = new Character();
		System.out.println("名前を入力してください");
		newchara.setName();
		System.out.println("職業を選択してください");
		System.out.println("1.戦士");
		System.out.println("2.野伏");
		System.out.println("3.僧侶");
		System.out.println("4.魔法使い");

		int key = input.getint();

		if(key == 1){
			newchara.setJob(new Fighter());
		}else if(key == 2){
			newchara.setJob(new Ranger());
		}else if(key == 3){
			newchara.setJob(new Priest());
		}else if(key == 4){
			newchara.setJob(new Mage());
		}

		Main.ch.add(newchara);
		return null;
	}

	void returndialog(Dialog dialog){
		this.returndialog = dialog;
	}
}
