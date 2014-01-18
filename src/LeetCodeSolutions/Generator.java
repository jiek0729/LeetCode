package LeetCodeSolutions;

public class Generator {
	public static ListNode GenerateListNode(int[] num){
		if(num == null || num.length == 0){
			return null;
		}
		
		ListNode head = new ListNode(num[0]);
		ListNode runner = head;
		
		for(int i = 1; i < num.length; i++){
			runner.next = new ListNode(num[i]);
			runner = runner.next;
		}
		
		return head;
	}
}
