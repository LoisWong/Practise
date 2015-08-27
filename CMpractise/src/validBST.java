
public class validBST {
    public boolean isValidBST(TreeLinkNode root) {
    	if (root == null){
    		return false;
    	}
        if (root.left == null && root.right == null){
        	return true;
        }else{
        	if (root.left != null && root.left.val < root.val){
        		isValidBST(root.left);
        	}else if (root.right != null && root.right.val > root.val){
        		isValidBST(root.right);
        	}return false;
        }
    }
}
