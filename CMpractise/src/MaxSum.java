//加上下一个数，如果仍为正，可继续加；如果为负，比较前方总值和当前最大和，取最大值

public class MaxSum {
	public int maxSubArray(int[] nums) {
        int l = nums.length;
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < l; i++){
        	sum = Math.max(sum+nums[i], nums[i]);
        	if (sum > max){
        		max = sum;
        	}
        }
        return max;
    }
}
