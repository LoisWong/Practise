
public class RemoveDuplicated {
	public static void main(String[] args){
		int[] nums = {1,1,2};
		int nl = removeDuplicates(nums);
		System.out.println(nl);
		for (int i = 0; i < nl; i++){
			System.out.print(nums[i]);
		}
	}
	public static int removeDuplicates(int[] nums) {
		//一位错位
		int length = nums.length;
		int j = 1;
		if (nums.length <= 1) 
			return nums.length;
        for (int i = 1; i < nums.length; i++){
        	if (nums[i] != nums[i-1]){
        		nums[j] = nums[i];
        		j++;
        	}
        	else{
        		length--;
        	}
        }
        return length;
		/*if(nums.length<=1)return nums.length;
        int i = 0;
        int j = 0;
        int cur = nums[j];
        while(j<nums.length){
            if(nums[j]!=cur){
                cur = nums[j];
                nums[i+1] = cur;
                i++;
            }
            j++;
        }
        return i+1;*/
    }
}
