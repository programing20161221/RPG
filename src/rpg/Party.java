package rpg;

import java.util.ArrayList;

public class Party {
	ArrayList<Character> ch = new ArrayList<Character>();

	void addparty(Character ch){
		if (this.ch.size() != 4)
			this.ch.add(ch);
		else
			System.out.println("上限が４人までです．");
	}

	void showParty(){
		for(int i = 0; i < Main.party.ch.size(); i++){
			System.out.println((i+1) + "." + Main.party.ch.get(i).getName());
		}
	}

	int sizeParty(){
		return this.ch.size();
	}

	String getMember(int key){
		if(sizeParty() > key)
			return ch.get(key).getName();
		return "*******";
	}

}
