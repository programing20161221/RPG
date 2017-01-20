package rpg;

public class Escape implements Bcommand {

	Text text = new Text();
	Dialog dialog;

	Escape (){;}

	Escape (String text, Dialog dialog){
		settext(text);
		setdialog(dialog);
	}

	void set(String text, Dialog dialog){
		settext(text);
		setdialog(dialog);
	}

	void settext(String message){
		text.setvalue(message);
	}

	void setdialog(Dialog locate){
		dialog = locate;
	}

	public Dialog action(Character c){
		return dialog;
	}

	public String show(){
		return text.getvalue();
	}

}
