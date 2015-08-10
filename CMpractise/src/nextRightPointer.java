
public class nextRightPointer {
	//based on level order traversal
    public void connect(TreeLinkNode root) {

        TreeLinkNode head = null; //head of the next level
        TreeLinkNode prev = null; //the leading node on the next level
        TreeLinkNode cur = root;  //current node of current level

        while (cur != null) {

            while (cur != null) { //iterate on the current level
                //left child
                if (cur.left != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    prev = cur.left;
                }
                //right child
                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    prev = cur.right;
                }
                //move to next node
                cur = cur.next;
            }

            //move to next level
            cur = head;
            head = null;
            prev = null;
        }

    }

}


//Another Solution
/*public void connect(TreeLinkNode root) {
    TreeLinkNode queue = root;
    while (queue != null) {
        TreeLinkNode level = new TreeLinkNode(0);
        TreeLinkNode current = level;
        while (queue != null) {
            if (queue.left != null) {
                current.next = queue.left;
                current = current.next;
            }
            if (queue.right != null) {
                current.next = queue.right;
                current = current.next;
            }
            queue = queue.next;
        }
        queue = level.next;
    }
}*/