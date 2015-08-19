import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Duplicate {
    public boolean containsDuplicate(int[] nums, int k) {
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
        /*Arrays.sort(nums);
     	for (int i = 1; i < nums.length; i++){
     		if (nums[i] == nums[i-1]){
     			return true;
     		}
     	}
     	return false;*/
    	//Duplicate II
    	int[] sortnums = new int[nums.length];
    	sortnums = nums;
    	int flag = 0;
    	int common = 0;
    	Arrays.sort(sortnums);
    	for (int i = 1; i < sortnums.length; i++){
     		if (sortnums[i] == sortnums[i-1]){
     			flag = 1;
     			common = sortnums[i];
     		}
     	}
    	if (flag == 1){
    		Stack<Integer> stack = new Stack<Integer>();
    		for (int i = 0; i < nums.length; i++){
    			if (nums[i] == common){
    				stack.push(i);
    			}
    		}
    		if (stack.pop()-stack.pop() < k){
    			return true;
    		}
    	}
    	else return false;
    	//Hash set solution with sliding window
    	Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }
}
