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
        
        ListNode firstNode = head;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tailHead = slow.next;
       
        slow.next = null; // split two linkedlist 
        ListNode reverseHead = reverse(tailHead);

        head = mergeList(firstNode, reverseHead);
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

    public ListNode mergeList(ListNode l1, ListNode l2)
    {
        ListNode dummy = new ListNode(0);

        ListNode cur = dummy;

        int count = 0;

        while(l1 != null && l2 != null)
        {
            if(count % 2 == 0)
            {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            }
            else
            {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
            count ++;
        }

        if(l1 != null)
        {
            cur.next = l1;
        }

        if(l2 != null)
        {
            cur.next = l2;
        }

        cur = dummy;

        while(cur != null)
        {
            System.out.println(cur.val);
            cur = cur.next;
        }

        return dummy.next;
    }
}
