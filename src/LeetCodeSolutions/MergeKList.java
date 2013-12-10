package LeetCodeSolutions;

import java.util.*;

public class MergeKList {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		System.out.println("start");
		
        ListNode head = new ListNode(0);
        
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size() + 1,
        new Comparator<ListNode>(){
            public int compare(ListNode node1, ListNode node2){
                return node1.val - node2.val;
            }
        });
        
        System.out.println("priority queue initialized");
        
        for(ListNode node : lists){
            queue.add(node);
        }
        
        System.out.println("Priority queue filled");
        
        ListNode cur = head;
        
        ListNode node = null;
        
        while((node = queue.poll()) != null){
            
            cur.next = node;
            
            if(node.next != null){
                queue.offer(node.next);
            }
            
            cur = cur.next;
        }
        
        return head.next;
    }
}
