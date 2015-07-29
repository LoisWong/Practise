import java.util.List;

public class Inorder {
    public List<Integer> inorderTraversal(TreeLinkNode root) {
    	List<Integer> list = null;
    	while (root != null){
    		
    		root = root.left;
    	}
        return list;
    }
}
