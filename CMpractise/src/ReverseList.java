
public class ReverseList {
	public ListNode reverseList(ListNode head) {
        ListNode rev = null;
        while (head.next != null){
        	ListNode temp = head.next;
        	head.next = rev;
        	rev = head;
        	head = temp;
        }
        return rev;
    }
	
	// Recursive solution 
	/*public ListNode reverseList(ListNode head) {
	    return reverseListInt(head, null);
	}

	public ListNode reverseListInt(ListNode head, ListNode newHead) {
	    if(head == null)
	        return newHead;
	    ListNode next = head.next;
	    head.next = newHead;
	    return reverseListInt(next, head);
	}*/
}
