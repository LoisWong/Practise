import java.util.HashSet;


public class SingleNum3 {
	public int[] singleNumber(int[] nums) {
	    int[] ans = new int[2];
	    if(nums == null || nums.length <=1){
	        return ans;
	    }

	    HashSet<Integer> record = new HashSet<Integer>();
	    for(int i = 0;i<nums.length;i++){
	        if(record.contains(nums[i])){
	            record.remove(nums[i]);
	        }
	        else{
	            record.add(nums[i]);
	        }
	    }
	    Object[] test = record.toArray();
	    ans[0]= (Integer) test[0];
	    ans[1]= (Integer) test[1];
	    return ans;
	}
}
