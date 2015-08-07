

public class sortcolor {
	static int[] nums;
	public static void main(String[] args){
		nums = new int[]{0,1,2};
		sortColors(nums);
		for (int i = 0; i < nums.length; i++){
			System.out.print(nums[i]);
		}
	}
	//Another method: count the number of different color and overwrite array
	public static void sortColors(int[] nums) {
        int begin = 0;
		int end = nums.length-1;
		int temp;
        for (int i = 0; i <= end; i++){
        	while (nums[i] == 2 && i < end){
        		temp = nums[end];
        		nums[end] = 2;
        		nums[i] = temp;
        		end--;
        	}
        	while (nums[i] == 0 && i > begin){
        		temp = nums[begin];
        		nums[begin] = 0;
        		nums[i] = temp;
        		begin++;
        	}
        }
    }
}
