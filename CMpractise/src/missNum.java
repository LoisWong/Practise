
public class missNum {
	public static void main(String[] args){
		int[] nums = {0,1,3};
		System.out.print(missingNumber(nums));
	}
	//Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
	//find the one that is missing from the array.
	//Your algorithm should run in linear runtime complexity. 
	//Could you implement it using only constant extra space complexity?
	public static int missingNumber(int[] nums) {
		/*Array list is disordered
		int i = 0;
        for (; i < nums.length; i++){
        	if (nums[i] != i){
        		break;
        	}
        }
		return i;*/

		//As it is only one number is missing
		int end = nums.length;
		int sum = 0;
		for(int num: nums)
            sum += num;
		return end*(end+1)/2-sum;
    }
}
