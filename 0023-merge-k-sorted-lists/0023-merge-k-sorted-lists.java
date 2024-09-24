/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] ls) {

     //create a prirority queue
      PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

     //now add list into pq
     for(ListNode node: ls){
        if(node != null)pq.add(node);
     }

     //now pq will hv smallest element in top of each list do pop it and add it's next to the queue as we already visited the smallest element in that group
     ListNode dummy = new ListNode();
     ListNode temp = dummy;
     while(!pq.isEmpty()){

        ListNode minNode = pq.poll();
        temp.next = minNode;
        temp = temp.next;

        if(minNode.next != null)    pq.add(minNode.next);
     }

     return dummy.next;
    }
}