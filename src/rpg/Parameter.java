package rpg;

public class Parameter {
	private Text text;
	private int value;
	private int max;
	private int min;

	public Parameter() {
		// TODO Auto-generated constructor stub
		this.text = new Text();
		this.value = 0;
		this.max = 10;
		this.min = 0;
	}

	String gettext() {
		return text.getvalue();
	}

	int getmax() {
		return this.max;
	}

	int getmin() {
		return this.min;
	}

	int getValue() {
		return value;
	}


	void setrange(int max, int min) {
		this.max = max;
		this.min = min;
	}

	void setValue(int value) {
		if (value > max)
			this.value = max;
		else if (value < min)
			this.value = min;
		else
			this.value = value;
	}

	void settext(String value) {
		text.setvalue(value);
	}

	int incvalue(int v) {
		this.value += v;
		if (this.value > max)
			return this.value = max;
		else if (this.value < min)
			return this.value = min;
		else
			return this.value;
	}

	String showvalue() {
		return String.valueOf(this.value);
	}

	String showvalue(int digit) {
		String str = String.valueOf(this.value);

		if (str.length() > digit) {
			return str.substring((str.length() - digit), str.length());
		} else {
			String format = "%" + String.valueOf(digit) + "s";
			return String.format(format, str);
		}
	}

}
