import java.util.HashMap;
import java.util.Scanner;

public class Majority {
	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		int[] nums = new int[6];
		for (int i = 0; i <= 5; i++){
			nums[i] = keyboard.nextInt();
		}
		System.out.println(majorityElement(nums));
		
	}
    public static int majorityElement(int[] nums) {
    	HashMap<Integer,Integer> numsmap = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> countmap = new HashMap<Integer,Integer>();
        int count;
        for (int i = 0; i < nums.length; i++){
        	if (numsmap.containsValue(nums[i])){
        		count = countmap.get(nums[i]);
        		count++;
        		countmap.put(nums[i], count);
        		if (count > nums.length/2){
        			return nums[i];
        		}
        	}else{
        		numsmap.put(i, nums[i]);
        		countmap.put(nums[i], 1);
        	}
        }
        return nums[0];
    }
}