package rpg;

import java.util.ArrayList;
import java.util.Random;

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

	int liveMember(){
		int l = 0;
		for(int i=0; i< Main.party.sizeParty() ;i++){
			if(!(ch.get(i).getLive())) continue;
			l++;
		}
		return l;
	}

	Character RandomMember(){
        Random rnd = new Random();
        int ran;
        while(true){
        	ran = rnd.nextInt(4);
        	if(ch.get(ran).getLive())
        		return ch.get(ran);
        }
	}

	Character getMember(int key){
		return ch.get(key);
	}

//	Icommand getIcommand(int key){
//		return ch.get(key).getIcommand();
//	}

	String getName(int key){
		if(sizeParty() > key)
			return ch.get(key).getName();
		return "*******";
	}

	String printPartystatus(){
		String p = "";
		p += "::::::::::::::::::::::::::::::::::::::::::::\n";
		for(int i = 0; i < this.sizeParty();i++){
			p += ch.get(i).getName()+": "+"("+ ch.get(i).getHp()+"/"+ ch.get(i).getMaxhp()+")";
			for(int hp = 0; hp < ch.get(i).getMaxhp() ;hp+=10){
//				String h="";
				if (hp >= ch.get(i).getHp())
					p += "-";
				else
					p += "*";
			}
			p += "\n";
//			p += h;
		}
		p += "::::::::::::::::::::::::::::::::::::::::::::\n";
		return p;
	}

}
