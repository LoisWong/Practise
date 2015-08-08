
public class SwapPairs {
	public ListNode swapPairs(ListNode head) {
		ListNode start = new ListNode(0); //make head no longer a special case
	    start.next = head;

	    for(ListNode cur = start; cur.next != null && cur.next.next != null; cur = cur.next.next) {
	      cur.next = swap(cur.next, cur.next.next);        
	    }
	    return start.next;
	  }
	  private ListNode swap(ListNode next1, ListNode next2) {
	    next1.next = next2.next;
	    next2.next = next1;
	    return next2;
    }
}
