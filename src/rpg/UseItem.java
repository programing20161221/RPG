package rpg;


public class UseItem implements Icommand{

	private Text Choice_message;

	UseItem(){
		this.Choice_message = new Text();
	}

	void settext(String text){ this.Choice_message.setValue(text);}

	public String showname(){
		return Choice_message.showvalue();
	}
	public Dialog action(){
		return null;
	}

}
