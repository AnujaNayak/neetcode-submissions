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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        //find the middle of the list to find the first and sec half
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        } 

        //reverse the sec half of the list
        ListNode tail = reverseSecondHalf(slow.next);

        slow.next = null;

        ListNode curr = head;
        ListNode frontNext = new ListNode();
        ListNode backNext = new ListNode();
        while(tail != null)
        {
            frontNext = curr.next;
            backNext = tail.next;

            curr.next = tail;
            tail.next = frontNext;
            curr = frontNext;
            tail = backNext;
        }
}

    public ListNode reverseSecondHalf(ListNode head)
    {
        ListNode curr = head;
        ListNode prev = null;
        ListNode temp = new ListNode();
        while(curr != null)
        {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}


