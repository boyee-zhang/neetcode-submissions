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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
        {
            return null;
        }

        ListNode cur = lists[0];
        for(int i = 1; i < lists.length; i ++)
        {
            cur = mergeList(cur,lists[i]);
        }

        return cur;
    }

    ListNode mergeList(ListNode list1, ListNode list2)
    {        
        ListNode cur = new ListNode(-1);
        ListNode head = cur;

        while(list1!= null && list2 != null)
        {
            //state check if 
            if(list1.val >= list2.val)
            {
                cur.next = list2;
                list2 = list2.next;
            }
            else
            {
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;
        }

        if(list1 != null)
        {
            cur.next = list1;
        }
        else if(list2 != null)
        {
            cur.next = list2;
        }

        return head.next;
    }
}
