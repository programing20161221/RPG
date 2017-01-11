package rpg;

public class CmdMove implements Icommand{
	Text text = new Text();
	Dialog dialog;

	CmdMove(){;}
	
	CmdMove(String text, Dialog dialog){
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
	
	public Dialog action(){
		return dialog;
	}
	
	String show(){
		return text.showvalue();
	}

	@Override
	public String showname() {
		// TODO Auto-generated method stub
		return text.showvalue();
	}
}
