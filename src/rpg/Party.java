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

}
