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
       ListNode fast = head;

        // splite the list to part_1 and part_2
        // keep part_1 and reverse part_2
        // traversal part_1 and intert part_2 node

       while(fast != null && fast.next != null)
       {
            slow = slow.next;
            fast = fast.next.next;
       }

        ListNode part_2Head = slow.next; //validate null 
        slow.next = null; // slite two list 
        part_2Head = reverseList(part_2Head);

        ListNode part1 = head;
        ListNode part2 = part_2Head;

        while(part2 != null)
        {
            ListNode next1 = part1.next;
            ListNode next2 = part2.next;

            part1.next = part2;
            part1.next.next = next1;

            //move to the next postion
            part1 = next1;
            part2 = next2;
        }

    }

    public ListNode reverseList(ListNode node)
    {
        if(node == null)
        {
            return null;
        }

        ListNode prev = null;
        ListNode cur = node;

        while(cur != null)
        {
            ListNode next = cur.next;
            cur.next = prev;

            // move to next position
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
