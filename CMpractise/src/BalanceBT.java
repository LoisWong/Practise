/*
 * Tidy version
private boolean result = true;

public boolean isBalanced(TreeNode root) {
    maxDepth(root);
    return result;
}

public int maxDepth(TreeNode root) {
    if (root == null)
        return 0;
    int l = maxDepth(root.left);
    int r = maxDepth(root.right);
    if (Math.abs(l - r) > 1)
        result = false;
    return 1 + Math.max(l, r);
}
 */
public class BalanceBT {
	public boolean isBalanced(TreeLinkNode root) {
	    if(root==null){
	        return true;
	    }
	    return height(root)!=-1;

	}
	public int height(TreeLinkNode node){
	    if(node==null){
	        return 0;
	    }
	    int lH=height(node.left);
	    if(lH==-1){
	        return -1;
	    }
	    int rH=height(node.right);
	    if(rH==-1){
	        return -1;
	    }
	    if(lH-rH<-1 || lH-rH>1){
	        return -1;
	    }
	    return Math.max(lH,rH)+1;
	}
}
