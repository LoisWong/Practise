
public class removeDuplicate {
	public ListNode deleteDuplicates(ListNode head) {
        
        ListNode newhead = new ListNode(0);
        newhead.next = head;
        ListNode go = newhead;
        if (head == null || head.next == null){
        	return head;
        }
        
        while (head != null){
        	while (head.next != null && head.val == head.next.val){
        	    head = head.next;
            }
            if (go.next == head){
                go = go.next;
            }
            else{
                go.next = head.next;
            }
        	head = head.next;
        }
        return newhead.next;
		
		//Recursive solution
		/*if (head == null) {
			return null;
		}
		if (head.next != null && head.val == head.next.val) {
	        while (head.next != null && head.val == head.next.val) {
	            head = head.next;
	        }
	        return deleteDuplicates(head.next);
	    }
		else {
	        head.next = deleteDuplicates(head.next);
	    }
	    return head;*/
	    
	    //Loops solution
	    /*if(head==null) return null;
        ListNode FakeHead=new ListNode(0);
        FakeHead.next=head;
        ListNode pre=FakeHead;
        ListNode cur=head;
        while(cur!=null){
            while(cur.next!=null&&cur.val==cur.next.val){
                cur=cur.next;
            }
            if(pre.next==cur){
                pre=pre.next;
            }
            else{
                pre.next=cur.next;
            }
            cur=cur.next;
        }
        return FakeHead.next;*/
    }
}
