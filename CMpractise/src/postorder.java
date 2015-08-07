
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


public class postorder {

	public List<Integer> postorderTraversal(TreeLinkNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeLinkNode> nodes = new Stack<TreeLinkNode>();
        TreeLinkNode temp = root;
		
        /*if (temp == null) return list;
		while (temp != null || !nodes.empty()){
			while (temp != null) {
				nodes.push(temp);
				if (temp.right != null) {
					nodes.push(temp.right);
				}
				temp = temp.left;
			}
			temp = nodes.pop();
			list.add(temp.val);
			temp = nodes.pop();
		}
        return list;*/
        
        if (root == null){
            return list;
        }else{
        	nodes.push(root);
        	while (!nodes.empty()){
        		temp = nodes.pop();
        		if (temp != null){
        			list.add(temp.val);
        			nodes.push(temp.left);
        			nodes.push(temp.right);	
        		}
        	}
        	Collections.reverse(list);
        	return list;
        }
    }
}

//Another solution without reverse
/*public List<Integer> postorderTraversal(TreeNode root) {
    Stack<TreeNode> traversal = new Stack<TreeNode>();
    List<Integer> res = new LinkedList<Integer>();

    if(root == null)
        return res;

    traversal.push(root);
    while(!traversal.isEmpty()){
        TreeNode top = traversal.pop();
        res.add(0, top.val);

        if(top.left != null){
            traversal.push(top.left);
        }

        if(top.right != null){
            traversal.push(top.right);
        }
    }
    return res;
}*/
