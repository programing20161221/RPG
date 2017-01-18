package rpg;
import	java.util.Random;;

public class Dice {
	public int cast(int num, int side){
		int sum = 0;
		Random rnd = new Random();
		
		for(int i = 0; i < num; i ++){
			sum = (Math.abs(rnd.nextInt()) % side) + 1 + sum;
		}
		return sum;
	}

	public int maxcast(int trial, int num, int side){
		int max = 0;
		int buf;
		
		for(int i = 0; i < trial; i ++){
			if(max < (buf = cast(num, side)))
				max = buf;
		}
		
		return max;
	}
}
