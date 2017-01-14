package rpg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
	
	String getstring() throws IOException{
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		return br.readLine();
	}
	
	int getint() throws NumberFormatException, IOException{
		return Integer.parseInt(getstring());
	}
	
}
