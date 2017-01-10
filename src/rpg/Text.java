package rpg;

public class Text {
	private String value;
	
	public Text() {
		// TODO Auto-generated constructor stub
		value = "lizard";
	}
	
	String getvalue(){
		return value;
	}
	
	String getValue(){
		return value;
	}
	
	void setvalue(String value){
		this.value = value;
	}
	
	void setValue(String value){
		this.value = value;
	}
	
	String showvalue(){
		return value;
	}
	
	String showvalue(int length){
		
		if(value.length() > length){
			return value.substring(0, length);
		}
		else{
			String format = "%" + String.valueOf(length) + "s";
			return String.format(format, value);
		}

	}

}
