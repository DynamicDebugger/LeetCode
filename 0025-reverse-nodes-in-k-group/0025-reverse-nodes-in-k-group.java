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
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = sizeOfList(head);

        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        ListNode temp = head;int c = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n ; i++){
            st.add(temp.val);
            c++;
            if(c == k){
                c = 0;
                while(!st.isEmpty()){
                    int top = st.pop();
                    res.next = new ListNode(top);
                    res = res.next;
                }
            }
            temp = temp.next;
        }
        while(!st.isEmpty()){
            res.next = new ListNode(st.remove(0));
            res = res.next;
        }
        return dummy.next;
    }
    int sizeOfList(ListNode head){
        ListNode temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
}