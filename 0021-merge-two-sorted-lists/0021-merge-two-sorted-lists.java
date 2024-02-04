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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode toInsert = list2, track;

        while (toInsert != null) {
            int data = toInsert.val;
            track = toInsert.next;
            ListNode main = list1, prev = null;

            while (main != null) {
                if (data < main.val) {
                    if (prev == null) {
                        // Insert at the beginning of list1
                        toInsert.next = main;
                        list1 = toInsert;
                    } else {
                        // Insert in the middle of list1
                        prev.next = toInsert;
                        toInsert.next = main;
                    }
                    break;
                }
                prev = main;
                main = main.next; // Inner loop incrementor
            }

            // Handle the case where data is greater than or equal to the last element in list1
            if (main == null && prev != null) {
                prev.next = toInsert;
                toInsert.next = null;
            }

            // Handle the case where data is greater than or equal to the last element in list1
            if (main == null && prev == null) {
                toInsert.next = list1;
                list1 = toInsert;
            }

            toInsert = track; // Outer loop incrementor
        }

        return list1;
    }
}