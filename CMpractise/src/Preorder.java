import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Preorder {
    public List<Integer> preorderTraversal(TreeLinkNode root) {
    	List<Integer> nl = new ArrayList<Integer>();
    	Stack<TreeLinkNode> stack = new Stack<TreeLinkNode>();
    	
        if (root == null){
            return nl;
        }else{
        	stack.push(root);
        	while (!stack.empty()){
        		TreeLinkNode temp = stack.pop();
        		if (temp != null){
        			nl.add(temp.val);
        			stack.push(temp.right);
        			stack.push(temp.left);
        		}
        	}
        	return nl;
        }
    }
}