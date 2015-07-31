import java.util.Arrays;

public class Duplicate {
    public boolean containsDuplicate(int[] nums) {
        /*int check;
        for (int i = 0; i < nums.length; i++){
            check = nums[i];
            for (int j = i+1; j < nums.length; j++){
                if (nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;*/
        Arrays.sort(nums);
     	for (int i = 1; i < nums.length; i++){
     		if (nums[i] == nums[i-1]){
     			return true;
     		}
     	}
     	return false;
    }
}
