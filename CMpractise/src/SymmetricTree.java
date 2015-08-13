
public class SymmetricTree {
	public boolean isSymmetric(TreeLinkNode root) {
	    return root==null || isSymmetricHelp(root.left, root.right);
	}

	private boolean isSymmetricHelp(TreeLinkNode left, TreeLnkNode right){
	    if(left==null || right==null)
	        return left==right;
	    if(left.val!=right.val)
	        return false;
	    return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
	}
}
