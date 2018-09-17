package fr.epita.math.calculus;

public class Factorial {

	
	public static int calculate(int depth) {
		if (depth == 1) {
			return 1;
		}else {
			return calculate(depth -1) * depth;
		}
		
		
	}
}
