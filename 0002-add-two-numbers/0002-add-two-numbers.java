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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode m = l1;
        ListNode n = l2;

        ListNode ans = new ListNode();
        ListNode temp = ans;int carry = 0;

        while(m != null || n != null || carry > 0){
            int sum = carry;
            if(m != null){
                sum += m.val;
                m = m.next;
            } 
            if(n != null){
                sum += n.val;
                n = n.next;
            } 
            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
        }
        ans = ans.next;
        return ans;
        
    }
    /*
           public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long n = reverseNum(listToNum(l1)) + reverseNum(listToNum(l2));
        ListNode ans = new ListNode();
        ListNode temp = ans;
        if(n == 0){
            ans.val = 0;
            return ans;
        }
        while(n > 0){
            long rem = n % 10;
            temp.next = new ListNode((int)rem);
            temp = temp.next;
            n/=10;
        }

        return ans.next;
    }

    public long listToNum(ListNode n){
        ListNode temp = n;
        long num = 0l;

        while(temp != null){
            num = (num * 10) + temp.val;
            temp = temp.next;
        }

        return num;
    }

    public long reverseNum(long n){
        long num = 0l;
        
        while(n > 0){
            long rem = n % 10;
            num = (num*10) + rem;
            n /= 10;
        }
        return num;
    }
    */
}