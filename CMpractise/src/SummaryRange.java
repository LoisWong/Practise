import java.util.ArrayList;
import java.util.List;


public class SummaryRange {
	public List<String> summaryRanges(int[] nums) {
	    int length = nums.length;
	    List<String> result = new ArrayList<String>(length);
	    for (int i = 0; i < length; i++) {
	        int num = nums[i];
	        //如果数字一直连续，则继续读取
	        while (i < length - 1 && nums[i] + 1 == nums[i + 1]) {
	            i++;
	        }
	        //只保存连续数字的范围或者不连续的单个数字
	        if (num != nums[i]) {
	            result.add(num + "->" + nums[i]);
	        } else {
	            result.add(num + "");
	        }
	    }
	    return result;
	}
}
