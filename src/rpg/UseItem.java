package rpg;


public class UseItem implements Bcommand{

	private Text Choice_message;

	UseItem(){
		this.Choice_message = new Text();
	}

	void settext(String text){ this.Choice_message.setvalue(text);}

	public String show(){
		return Choice_message.getvalue();
	}
	public Dialog action(Character c){
		System.out.println("item");
		return null;
	}

}
