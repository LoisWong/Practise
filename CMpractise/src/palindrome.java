
public class palindrome {
	//在O(n)时间和O(1)空间内判断数列是否是回文数
	public static void main(String[] aregs){
		ListNode head = new ListNode(1){};
		head.next = new ListNode(2){};
		if (isPalindrome(head)){
			System.out.println("Is palindrome.");
		}else System.out.println("Not");
	}
	public static boolean isPalindrome(ListNode head) {
        //一快一慢两个指针判断数列中间值，另外指针做数组反向
		if (head == null || head.next == null){
			return true;
		}else{
			ListNode slow,fast;
			ListNode midhead = head.next;
			head.next = null;
			slow = head;
			head = midhead;
			midhead = slow;
			fast = slow;
			while (fast != null && fast.next != null){
				slow = slow.next;
				fast = fast.next.next;
				ListNode temp = head.next;
				head.next = midhead;
				midhead = head;
        		head = temp;
			}
			while (slow != null || midhead != null){
				if (slow != midhead){
					return false;
				}
				slow = slow.next;
				midhead = midhead.next;
			}
			return true;
		}
    }
}
	/* public boolean isPalindrome(ListNode head) {

	        if(head==null || head.next==null){
	            return true;
	        }

	        ListNode mid = findMiddle(head);
	        ListNode midhead = mid.next;

	        ListNode reverseHead = reverse(midhead);

	        while(reverseHead!=null){
	            if(head.val==reverseHead.val){
	                head = head.next;
	                reverseHead = reverseHead.next;
	            }else{
	                return false;
	            }
	        }

	        return true;
	    }

	    public ListNode findMiddle(ListNode head1){
	        ListNode fast = head1.next;
	        ListNode slow = head1;
	        while(fast!=null && fast.next!=null){
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        return slow;
	    }

	    public ListNode reverse(ListNode head2){
	        ListNode pre = null;
	        while(head2!=null){
	            ListNode tmp = head2.next;
	            head2.next = pre;
	            pre = head2;
	            head2 = tmp;
	        }
	        return pre;
	    }*/