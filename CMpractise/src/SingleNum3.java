import java.util.HashSet;
import java.util.Set;


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
	/*public int[] singleNumber(int[] nums) {
	    Set<Integer> set = new HashSet<Integer>();
	    for(int i:nums){
	         if(set.add(i)==false)
	         set.remove(i);
	    }
	    int a[]= new int [set.size()];
	    int c=0;
	    for(int b:set){
	        a[c]=b;
	        c++;
	    }
	    return a;
	}*/
}
