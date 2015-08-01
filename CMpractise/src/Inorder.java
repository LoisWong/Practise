import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Inorder {
    public List<Integer> inorderTraversal(TreeLinkNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	Stack<TreeLinkNode> stack = new Stack<TreeLinkNode>();
    	TreeLinkNode temp = root;
    	while (temp != null || !stack.empty()){
    		while (temp != null){
    			stack.push(temp);
    			temp = temp.left;
    		}
    		temp = stack.pop();
    		list.add(temp.val);
    		temp = temp.right;
    	}
        return list;
    }
}
