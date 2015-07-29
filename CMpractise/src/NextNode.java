public class NextNode {
    public void connect(TreeLinkNode root) {
        TreeLinkNode leftTree = root;
        
        while(leftTree != null){
        	//Go through all the left nodes
        	TreeLinkNode across = leftTree;
        	while (across != null) {
        		//Complete same line link
				if (across.left != null) {
					across.left.next = across.right;
					if (across.next == null) {
						across.right.next = null;
					} else {
						across.right.next = across.next.left;
					}
				}
				across = across.next;
			}
        	leftTree = leftTree.left;
        }
    }
}