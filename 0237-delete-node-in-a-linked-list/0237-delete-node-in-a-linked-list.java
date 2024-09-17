/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        
        // 1 -> 2 -> 3 -> 4 -> 5
        // delete 3
        // 1 -> 2 -> 4 -> 5
        // if just iterate and put next val in prev val
        ListNode prev = node;
        ListNode cur = node.next;
        while(cur.next != null){
            prev.val = cur.val;
            prev = cur;
            cur = cur.next;
        }
        prev.val = cur.val;
        prev.next = null;
    }
}