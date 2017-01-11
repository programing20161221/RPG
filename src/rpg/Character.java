package rpg;

import java.io.IOException;

public class Character extends BChara{
	private Parameter lv;
	private Text name;
	private Job job;
	private Ability ability;
	private Equip weapon;
	private Equip armor;
	private Equip shield;
	private Parameter hp;
	private Parameter mp;
	private Parameter ap;
	private Dialog campdialog;
	private Dialog battledialog;
	private Input input;
	private Character party;

	public Character() {
		// TODO Auto-generated constructor stub
		this.lv = new Parameter();
		this.name = new Text();
		this.ability = new Ability();
		this.weapon = new Equip();
		this.armor = new Equip();
		this.shield = new Equip();
		this.hp = new Parameter();
		this.mp = new Parameter();
		this.ap = new Parameter();
		this.campdialog = new Dialog();
		this.battledialog = new Dialog();
		this.input = new Input();
		this.job = new Job();
		
		lv.setrange(100, 1);
	}
	
	
	public Character getParty() {
		return party;
	}

	public void setParty(Character party) {
		this.party = party;
	}

	public void setName() throws IOException {
		this.name.setValue(input.getstring());
	}
	
	public void setJob(Job job){
		this.job = job;
	}
	
	int mhp(){
		return (int)((lv.getValue() + ability.getstrength()) * job.getmhptate());
	}
	
	int mmp(){
		return (int)(lv.getValue() + ability.getintelligence() * job.getmhptate());
	}
	
	int incap(){
		return (int)(lv.getValue() + ability.getagility() * job.getincaprate());
	}
	
	int getstrength(){
		return ability.getstrength(); //+ weapon.getstrength + armor.getstrength + shield.getstrength;
	}


	public void setName(Text name) {
		this.name = name;
	}


	//途中
	void getstatus(){
		System.out.println("Name :" + name.getvalue());
		System.out.println("Job  :" + job.getname().getvalue());
		System.out.println("Level:" + lv.getValue());
	}
	
	void levelup(){
		lv.setValue(lv.getValue() + 1);
		
		hp.setrange(mhp(), 0);
		mp.setrange(mmp(), 0);
		ap.setrange(incap(), 0);
		
		hp.setValue(hp.getmax());
		mp.setValue(mp.getmax());
		ap.setValue(ap.getmax());
	}
	
	void initstatus(){		
		lv.setValue(1);
		hp.setrange(mhp(), 0);
		mp.setrange(mmp(), 0);
		ap.setrange(incap(), 0);
		
		ability.setability(lv.getValue());
	}
	
}
