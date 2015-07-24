package Common;

import java.util.Arrays;


public class common_value {
	public static void main(String[] args){
		try {
			//Only for testing use	
			//Getting command-line arguments as input array
			int[] common,number = new int [args.length];
			for (int i=0; i<args.length; i++){
				number[i] = Integer.parseInt(args[i]);
			} 
			common = Common(number);
			for(int i:common) {
				System.out.print(i + " ");
			}
		} catch (Exception e) {
			System.out.print("No number in the array.");
		}
	}

	private static int[] Common(int[] args) throws Exception {
		int len = args.length;
		if (len == 0){
			throw new Exception();
		}
		//Store the times that the number has appeared
		int[] times = new int[len];
		//Sorting the array for future use
		Arrays.sort(args);
		//Initial the first number appears once, max times is 1
		times[0] = 1;
		int max = 1;
		//Store appeared times of each number and finding the max times
		for(int i = 1; i < len; i++){
			if (args[i] == args[i-1]){
				times[i] = times[i-1] + 1;
				if (times[i] > max){
					max = times[i];
				}
			}
			else {
				times[i] = 1;
			}
		}
		//Store the number, which appeared times equal to max
		int[] commonRaw = new int[len];
		int j = 0;
		for (int i = 0; i < len; i++){
			if (times[i] == max){
				commonRaw[j] = args[i];
				j++;
			}
		}
		//Cut Arrays length
		int[] common = new int[j];
		for (int i = 0; i < j; i++){
			common[i] = commonRaw[i];
		}
		return common;
	}
}
