
public class mergeList {
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		 /*if (l1 == null && l2 == null) {
	            return null;
	     }
		 if (l1 == null) {
	            return l2;
	     }
		 if (l2 == null) {
	            return l1;
	     }
		 ListNode newList;
		 ListNode temp;
		 if (l1.val <= l2.val){
			 newList = l1;
			 l1 = l1.next;
		 }else {
			 newList = l2;
			 l2 = l2.next;
		 }
		 temp = newList;
		 while (l1 != null && l2 != null){
			 if (l1.val <= l2.val){
				 temp.next = l1;
				 l1 = l1.next;
			 }else{
				 temp.next = l2;
				 l2 = l2.next;
			 }
			 temp = temp.next;
		 }
		 if (l1 == null){
			 temp.next = l2;
		 }
		 if (l2 == null){
			 temp.next = l1;
		 }
		 return newList;*/
		 
		 if (l1 == null) return l2;
		 if (l2 == null) return l1;
		 
		 if (l1.val <= l2.val){
			 l1.next = mergeTwoLists(l1.next, l2);
			 return l1;
		 }else{
			 l2.next = mergeTwoLists(l1, l2.next);
			 return l2;
		 }
	 }
}
