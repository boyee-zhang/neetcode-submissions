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
        if(list1 == null)
        {
            return list2;
        }
        if(list2 == null)
        {
            return list1;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;

        ListNode p1 = list1;
        ListNode p2 = list2;  // for iterate  two LinkedList 

        while(p1 != null && p2 != null)
        {
            if(p1.val <= p2.val)
            {
                cur.next = new ListNode(p1.val);
                p1 = p1.next;
            }
            else
            {
                cur.next = new ListNode(p2.val);
                p2 =p2.next;
            }
            
            // move to the next point
            System.out.println(cur.val);
            cur = cur.next;
        }

        if(p1 != null)
        {
            cur.next = p1;
        }
        if(p2 != null)
        {
            cur.next = p2;
        }

        return dummyHead.next;

    }
}