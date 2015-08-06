
public class SAToBST {
	 public TreeLinkNode sortedArrayToBST(int[] nums) {
	        int l = nums.length;
	        if (l > 0){
	        	/*TreeLinkNode Root = new TreeLinkNode(nums[l/2]);
	        	Root.left = setTree(nums, 0, l/2-1);
	        	Root.right = setTree(nums, l/2+1, l-1);
	        	return Root;*/
	        	TreeLinkNode Root = setTree(nums, 0, l-1);
	        	return Root;
	        }else return null;
	 }
	 public TreeLinkNode setTree(int[] nums, int left, int right){
		 int middle = (left + right)/2;
		 if (left > right){
			 return null;
		 }else {
			 TreeLinkNode Root = new TreeLinkNode(nums[middle]);
			 Root.left = setTree(nums, left, middle-1);
			 Root.right = setTree(nums, middle+1, right);
			 return Root;
		 }
	 }
}
