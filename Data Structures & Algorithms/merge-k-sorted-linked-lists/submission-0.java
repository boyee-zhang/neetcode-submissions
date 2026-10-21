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

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);

        for(ListNode list : lists)
        {
            if(list != null)
            pq.add(list);
        }
        

        // some bug may happen
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;


        while(!pq.isEmpty())
        {   
            ListNode newNode = pq.poll();
            cur.next = newNode;
            cur = cur.next;
            
            // add the new node to pq
            if(newNode.next != null)
            {
                pq.add(newNode.next);
            }
        }

        return dummy.next;
    }
}
