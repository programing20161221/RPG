package rpg;


public class Fight implements Bcommand{
	private Text text;
	private Dialog dialog;

	private Party party;
	private Monster monster;

	Fight(Monster m, Party p){
		this.text = new Text();
		this.dialog = new Dialog();
		this.monster = m;
		this.party = p;
	}

	void settext(String text){ this.text.setvalue(text);}

//	public Character getHero() {return hero;}
//	public void setHero(Character hero) {this.hero = hero;}

	public Monster getMonster() {return monster;}
	public void setMonster(Monster monster) {this.monster = monster;}

	public Dialog getDialog() {return dialog;}
	public void setDialog(Dialog dialog) {this.dialog = dialog;}

	public String show(){return text.getvalue();}
	public Dialog action(Character c){
		// player turn
//		for(int i=1; i<= party.sizeParty() ;i++){

//		}
//		System.out.println("fight");
		System.out.println(c.getName()+"の攻撃！     " + c.getAttack()+"のダメージ!!を与えた!!");
		monster.setHp(monster.getHp() - c.getAttack());
		// monster turn
//		Character ch = party.RandomMember();
//		System.out.println("敵からの攻撃!\n"+ch.getName()+"が"+ monster.getAttack()+"のダメージを食らった!!");
//		ch.setHp(ch.getHp()- monster.getAttack());
//		System.out.println(ch.getName()+": ("+ch.getHp()+"/"+ch.getMaxhp()+")\n");
//		System.out.println(monster.getName()+"("+monster.getHp()+"/"+monster.getMaxhp()+")");
		return dialog;
	}

}
