package rpg;


public class Fight implements Icommand{
	private Text text;
	private Dialog dialog;

	private Character hero;
	private Monster monster;

	Fight(){
		this.text = new Text();
		this.dialog = new Dialog();
		this.monster = new Monster();
		this.hero = new Character();
	}

	void settext(String text){ this.text.setvalue(text);}

	public Character getHero() {return hero;}
	public void setHero(Character hero) {this.hero = hero;}

	public Monster getMonster() {return monster;}
	public void setMonster(Monster monster) {this.monster = monster;}

	public Dialog getDialog() {return dialog;}
	public void setDialog(Dialog dialog) {this.dialog = dialog;}

	public String show(){return text.showvalue();}
	public Dialog action(){
		// player turn
		System.out.println("こちらの攻撃!"+ (monster.getHp().getValue() - hero.getAttack().getValue())+"のダメージ!!を与えた!!");
		monster.setHp(monster.getHp().getValue() - hero.getAttack().getValue());

		// monster turn
		System.out.println("敵からの攻撃!"+ (hero.getHp().getValue() - monster.getAttack().getValue())+"のダメージを食らった!!");
		hero.setHp(hero.getHp().getValue() - monster.getAttack().getValue());
		return dialog;
	}

}
