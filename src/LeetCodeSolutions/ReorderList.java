package LeetCodeSolutions;

public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        
        ListNode mid = head, end = head.next;
        
        while(end != null && end.next != null){
            mid = mid.next;
            end = end.next.next;
        }
        
        reverse(mid);
        
        ListNode runner = head;
        
        while(runner != null && mid.next != null){
            ListNode temp = mid.next;
            mid.next = mid.next.next;
            temp.next = runner.next;
            runner.next = temp;
            runner = runner.next.next;
        }
    }
    
    private void reverse(ListNode pre){
        if(pre.next == null){
            return;
        }
        ListNode tail = pre.next;
        ListNode curr = tail.next;
        
        while(curr != null){
            tail.next  = curr.next;
            curr.next = pre.next;
            pre.next = curr;
            curr = tail.next;
        }
    }
    
    public static void main(String[] args){
    	ReorderList rl = new ReorderList();
    	
    	int[] num = {1,2,3,4,5,6,7,9,10,11,12,13,14,15};
    	
    	ListNode head = Generator.GenerateListNode(num);
    	
    	Printer.printListNode(head);
    	
    	rl.reorderList(head);
    	
    	Printer.printListNode(head);
    }
}
