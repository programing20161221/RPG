package rpg;

public class Character extends BChara{
	private Parameter lv;
//	private Text name;
	private Parameter EXP;	 //if EXP greater than equal lv*ratio, Character’s Level UP　and EXP is initialized to zero!
	private Parameter EXPratio;
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

	private Bcommand Bcom;

	public Character() {
		// TODO Auto-generated constructor stub
		this.lv = new Parameter();
//		this.name = new Text();
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
		this.EXP = new Parameter();
		lv.setrange(100, 1);
		lv.setValue(1);
	}

	public int getLv() {
		return lv.getValue();
	}

	public void setLv(Parameter lv) {
		this.lv = lv;
	}

	public int getEXP() {
		return EXP.getValue();
	}

	public void setEXP(int eXP) {
		EXP.setValue(eXP + EXP.getValue());
	}

	public Parameter getEXPratio() {
		return EXPratio;
	}

	public void setEXPratio(Parameter eXPratio) {
		EXPratio = eXPratio;
	}

	public void setBcommand(Bcommand i){
		this.Bcom = i;
	}

	public Bcommand getBcommand(){
		return this.Bcom;
	}


	public Character getParty() {
		return party;
	}

	public void setParty(Character party) {
		this.party = party;
	}

//	public void setName() throws IOException {
//		this.name.setvalue(input.getString());
//	}

	public void setJob(Job job){
		this.job = job;
	}

	public Job getJob(){
		return this.job;
	}

	int mhp(){
		return (int)((lv.getValue() * 10 + ability.getstrength()) * job.getmhptate());
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


//	public String getName(){
//		return this.name.getvalue();
//	}

//	void setName(Text name) {
//		this.name = name;
//	}

//	void setName(String name) {
//		this.name.setvalue(name);
//	}

	//途中
	void getstatus(){
		System.out.println("Name :" + getName());
		System.out.println("Job  :" + job.getname().getvalue());
		System.out.println("Level:" + lv.getValue());
		System.out.println("EXP:" + EXP.getValue());
	}

	void levelup(){
		lv.setValue(lv.getValue() + 1);

		hp.setrange(mhp(), 0);
		mp.setrange(mmp(), 0);
		ap.setrange(incap(), 0);

		hp.setValue(hp.getMax());
		mp.setValue(mp.getMax());
		ap.setValue(ap.getMax());
	}

	void initstatus(){
		lv.setValue(1);
		hp.setrange(mhp(), 0);
		mp.setrange(mmp(), 0);
		ap.setrange(incap(), 0);
		hp.setValue(mhp());
		mp.setValue(mmp());
		ap.setValue(incap());

		ability.setability(lv.getValue());
	}

	int chkExp(){
		if(this.EXP.getValue() >=  lv.getValue() * 100){
			lv.setValue(lv.getValue()+1);
			this.EXP.setValue(0);
		}
		return lv.getValue();
	}

	void showCharacter(){
		for(int i = 0; i < Main.ch.size(); i++){
			System.out.println((i+1) + "." + Main.ch.get(i).getName());
		}
	}

}
