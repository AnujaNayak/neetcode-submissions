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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode l = dummy;
        ListNode r = head;

        int count = 0;
        while(count < n)
        {
            r = r.next;
            count++;
        }

        while(r != null){
            l = l.next;
            r = r.next;
        }

        l.next = l.next.next;

        return dummy.next;
    }
}
