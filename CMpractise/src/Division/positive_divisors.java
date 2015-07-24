package Division;

import java.util.ArrayList;
//import java.util.Collections;
import java.util.Scanner;


public class positive_divisors {
	public static ArrayList<Integer> Divisors(int x){
		ArrayList<Integer> allDivisors = new ArrayList<Integer>();
		//First method to calculate all positive divisors
		for (int i = 1; i <= x; i++){
			//If find a positive divisor, then store it
			if (x % i == 0){
				allDivisors.add(i);
			}
		}
		return allDivisors;
		
//	    //A new method to reduce calculate times
// 	    //When a divisor is bigger than the root, it means a small divisor has been found already.
//      //If we have stored all divisors before, then no more calculate is needed. 

//		int flag = (int) Math.sqrt(x);
//		for (int i = 1; i <= flag; i++ ){
//			if (x % i == 0){
//		    //Finding positive divisors
//              //In case of repeating divisor
//				if (i != flag){
//					allDivisors.add(i);
//					allDivisors.add(x/i);
//				}
//				else {allDivisors.add(i);}
//			}
//		}
//		Collections.sort(allDivisors);
//		return allDivisors;
		
	}
	public static void main(String[] args){
		//This part only for testing use
		Scanner keyboard = new Scanner(System.in);
		for(int i = keyboard.nextInt(); i > 0; i = keyboard.nextInt()){
			ArrayList<Integer> divisors = new ArrayList<Integer>();
			divisors = Divisors(i);
			for (int counter: divisors){
				System.out.print(counter + " ");
			}
		}
	}
}
