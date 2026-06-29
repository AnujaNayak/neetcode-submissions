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
        int carryOver = 0;
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while(l1 != null || l2 != null)
        {
            int val1 = (l1 == null) ? 0 : l1.val;
            int val2 = (l2 == null) ? 0 : l2.val;
            int sum = val1 + val2 + carryOver;
            carryOver = sum / 10;
            int addedVal = sum % 10;
            curr.next = new ListNode(addedVal);
            curr = curr.next;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 == null) ? null : l2.next;
        }
        if(carryOver > 0)
        {
            curr.next = new ListNode(carryOver);
        }
        return dummy.next;
    }
}
