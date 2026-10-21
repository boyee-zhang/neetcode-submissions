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
        
        //
        ListNode dummy = new ListNode (-1);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tailHead= slow.next;

        ListNode reverseTail = reverse(tailHead);

        // while(reverseTail != null)
        // {
        //     System.out.println(reverseTail.val);
        //     reverseTail = reverseTail.next;
        // }

        slow.next = null;  //split two list

        //merge two list head and tailHead

        while(head != null && reverseTail != null)
        {
            ListNode next = head.next;
            ListNode tailNext = reverseTail.next;

            head.next = reverseTail;
            reverseTail.next = next;
            
            head = next;
            reverseTail = tailNext;
        }


    }

    public ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        ListNode cur = head;

        while(cur != null)
        {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;

            cur = next;
        }

        return prev;
    }
}
