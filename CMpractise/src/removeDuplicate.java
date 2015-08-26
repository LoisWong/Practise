
public class removeDuplicate {
	public ListNode deleteDuplicates(ListNode head) {
        ListNode newhead = head;
        ListNode go;
        if (head == null || head.next == null){
        	return newhead;
        }
        while (head.val == head.next.val){
        	head = head.next;
        }
        newhead = head;
        while (head.next != null){
        	go = head.next;
            newhead.next = deleteDuplicates(go);
        }
        return newhead;
    }
}
