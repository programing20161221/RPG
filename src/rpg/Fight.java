package rpg;


public class Fight implements Icommand{
	private Text text;
	private Dialog dialog;

	private Character hero;
	private Monster monster;

	Fight(Monster m){
		this.text = new Text();
		this.dialog = new Dialog();
		this.monster = m;
		this.hero = new Character();
	}

	void settext(String text){ this.text.setvalue(text);}

	public Character getHero() {return hero;}
	public void setHero(Character hero) {this.hero = hero;}

	public Monster getMonster() {return monster;}
	public void setMonster(Monster monster) {this.monster = monster;}

	public Dialog getDialog() {return dialog;}
	public void setDialog(Dialog dialog) {this.dialog = dialog;}

	public String show(){return text.getvalue();}
	public Dialog action(){
		// player turn
		System.out.println("hp:"+monster.getHp() );
		System.out.println("attack:"+hero.getAttack());
		System.out.println("こちらの攻撃!"+ (monster.getHp() - hero.getAttack())+"のダメージ!!を与えた!!");
		monster.setHp(monster.getHp() - hero.getAttack());
//		monster.setHp(50);


		// monster turn
		System.out.println("敵からの攻撃!"+ (hero.getHp() - monster.getAttack())+"のダメージを食らった!!");
		hero.setHp(hero.getHp()- monster.getAttack());

		System.out.println(monster.getName()+"("+monster.getHp()+"/"+monster.getMaxhp()+")");
		return dialog;
	}

}
