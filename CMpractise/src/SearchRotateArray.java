//import java.util.Scanner;


public class SearchRotateArray {
	public static void main(String[] args){
		//Scanner in = new Scanner(System.in);
		int[] nums = {5,1,3};
		System.out.print(search(nums, 3));
	}
	public static int search(int[] nums, int target) {
		int start = 0;
		int end = nums.length-1;
		
        if (end == -1){
        	return -1;
        }
        while (start <= end) {
        	int mid = (start + end)/2;
        	if (nums[mid] == target){
        		return mid;
        	}else {
        		//找到规律排列的部分才便于使用二分法，在规律排列的数列中是否有可能包含数字
        		if (nums[start] <= nums[mid]) {//前半部分规律
        			if (target > nums[mid] || target < nums[start]){//不在范围
        				start = mid+1;
        			}else {//范围内
        				end = mid-1;
        			}
        		}else if (nums[mid] <= nums[end]){//后半部分规律
        			if (target > nums[end] || target < nums[mid]){//不在范围
        				end = mid-1;
        			}else {//范围内
        				start = mid+1;
        			}
        		}
        	}
        }
        return -1;
    }
}
