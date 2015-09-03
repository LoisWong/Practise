import java.util.ArrayList;
import java.util.List;
//["1->2->5", "1->3"]

public class BTPath {
    public List<String> binaryTreePaths(TreeLinkNode root) {
        List<String> btps = new ArrayList<String>();
        if (root != null){
        	searchBT(root,"",btps);
        }
        return btps;
    }
    private void searchBT(TreeLinkNode root, String path, List<String> btps){
    	if (root.left == null && root.right == null){
    		btps.add(path + root.val);
    	}
    	if (root.left != null){
    		searchBT(root.left, path+root.val+"->", btps);
    	}
    	if (root.right != null){
    		searchBT(root.right, path+root.val+"->", btps);
    	}
    }
}
