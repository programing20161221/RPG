package rpg;

public class Ability {
	private Parameter strength;
	private Parameter intelligence;
	private Parameter vitality;
	private Parameter agility;
	private Parameter luck;
	private Dice dice;

	Ability(){
		this.strength = new Parameter();
		this.intelligence = new Parameter();
		this.vitality = new Parameter();
		this.agility= new Parameter();
		this.luck = new Parameter();
		this.dice = new Dice();

		this.strength.setrange(300, 3);
		this.intelligence.setrange(300, 3);
		this.vitality.setrange(300, 3);
		this.agility.setrange(300, 3);
		this.luck.setrange(300, 3);
	}

	public void setability(int lv) {
		this.strength.setValue(dice.maxcast(10, lv, 3));
		this.intelligence.setValue(dice.maxcast(10, lv, 3));
		this.vitality.setValue(dice.maxcast(10, lv, 3));
		this.agility.setValue(dice.maxcast(10, lv, 3));
		this.luck.setValue(dice.maxcast(10, lv, 3));

	}

	int getstrength(){
		return strength.getValue();
	}

	int getintelligence(){
		return intelligence.getValue();
	}

	int getvitality(){
		return vitality.getValue();
	}

	int getagility(){
		return agility.getValue();
	}

	int getluck(){
		return luck.getValue();
	}

}
