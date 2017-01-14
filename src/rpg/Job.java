package rpg;

public class Job {
	Text name;
	double mhprate;
	double mmprate;
	double incaprate;
	
	Job(){
		this.name = new Text();
		this.mhprate = 1;
		this.mmprate = 1;
		this.incaprate = 1;
	}
	
	Text getname(){
		return name;
	}
	
	double getmhptate(){
		return mhprate;
	}
	
	double getmmprate(){
		return mmprate;
	}
	
	double getincaprate(){
		return incaprate;
	}
}
