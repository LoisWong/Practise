
public class Product {
	public static void main(String[] args){
		int num[] = {0,2,0,4};
		int pnum[] = productExceptSelf(num);
		for (int i = 0; i < pnum.length; i++){
			System.out.print(pnum[i]+" ");
		}
	}
	public static int[] productExceptSelf(int[] nums) {
		/*int n = nums.length;
		int[] res = new int[n];
		res[0] = 1;
		//Get product of prior elements.
		for (int i = 1; i < n; i++) {
			res[i] = res[i - 1] * nums[i - 1];
		}
		//Get product of after elements and multiply with prior result
		int right = 1;
		for (int i = n - 1; i >= 0; i--) {
			res[i] *= right;
			right *= nums[i];
		}
		return res;*/
		int n = nums.length;
		int res = 1;
		int[] result = new int[n];
		int zero =0;
		for (int i = 0; i < n; i++){
			if (nums[i]==0){
				zero++;
				if (zero > 1) {
					res = 0; 
					break;
				}
			}else{
				res *= nums[i];
			}
		}
		for (int i = 0; i < n; i++){
			if (nums[i]==0){
				result[i] = res;
			}else if(zero >= 1){
				nums[i] = 0;
			}else 
				result[i] = res/nums[i];
		}
		return result;
	}
}
