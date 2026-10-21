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
        // the edge case is if n > list size
        // but according to the condition of this question we know the only edge case is the n == head

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;

        while(n >= 0)
        {
            fast = fast.next;
            n--;
        }

        ListNode slow = dummy;

        while(fast != null)
        {
            fast = fast.next;
            slow = slow.next;
        }

        //slow is the postion that need to delete node's previous one node
        slow.next = slow.next.next;
        return dummy.next;
    }
}
