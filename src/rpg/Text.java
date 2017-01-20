package rpg;

public class Text {
	private String value;

	public Text() {
		value = "TEXTNAME";
	}

	String getvalue(){
		return value;
	}


	void setvalue(String value){
		this.value = value;
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
