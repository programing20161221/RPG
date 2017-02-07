package rpg;

public class BChara{
	private Text name;
//	private Parameter maxhp;
	private Parameter hp;
	private Parameter mp;
	private Parameter ap;
	private Boolean live;
	private Parameter attack;
	private Parameter defense;

	public void setName(String text){this.name.setvalue(text);}
	public String getName(){ return name.getvalue(); }

	public void setLive(Boolean l){this.live = l;}
	public Boolean getLive(){return this.live;}
	public int getMaxhp() {return hp.getMax();}
	public void setMaxhp(int max) {this.hp.setMax(max);}
	public int getMinhp() {return hp.getMin();}
	public void setMinhp(int min) {this.hp.setMax(min);}
	public int getHp() {return hp.getValue();}
	public void setHp(int hp) {this.hp.setValue(hp);}

	public Parameter getMp() {return mp;}
	public void setMp(int mp) {this.mp.setValue(mp);}
	public Parameter getAp() {return ap;}
	public void setAp(int ap) {this.ap.setValue(ap);}

	public int getAttack() {return attack.getValue();}
	public void setAttack(int attack) {this.attack.setValue(attack);}
	public Parameter getDefense() {return defense;}
	public void setDefense(int defense) {this.defense.setValue(defense);}

	BChara(){
		initInstance();
		this.setName("test");
		this.setAttack(10);
		this.setDefense(10);
		this.setMaxhp(100);
		this.setHp(10);
		setMp(10);
		setAp(5);
		setLive(true);
	}

	BChara(String str){
		initInstance();
		this.setName(str);
		this.setAttack(1);
		this.setDefense(1);
		this.setMaxhp(20);
		this.setHp(20);
		setMp(10);
		setAp(5);
		setLive(true);
	}

	public void initInstance(){
		name = new Text();
//		maxhp = new Parameter();
		hp = new Parameter();
		mp = new Parameter();
		ap = new Parameter();
		attack = new Parameter();
		defense = new Parameter();
	}


}
