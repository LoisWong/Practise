import java.util.Arrays;

public class KthLargest {
	public static void main(String[] args){
		int[] nums = {2,1,3,7,5,6,4};
		System.out.print(findKthLargest(nums,2));
	}
    public static int findKthLargest(int[] nums, int k) {
       Arrays.sort(nums);
       int l = nums.length;
       return nums[l-k];
    }
}
