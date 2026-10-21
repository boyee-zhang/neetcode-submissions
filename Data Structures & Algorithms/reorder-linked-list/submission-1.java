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
        
        ListNode cur = head;

        List<ListNode> l = new LinkedList<>();

        while(cur != null)
        {
            l.add(cur);
            cur = cur.next;
        }

        // for(int i = 0; i < l.size(); i ++)
        // {
        //     System.out.println(l.get(i).val);
        // }
        
        int left = 0;
        
        int right = l.size() - 1;

        while(left < right)
        {
            l.get(left).next = l.get(right);

            left ++;
            if(left >= right)
            {
                break;
            }
            l.get(right).next = l.get(left);
            right --;
        }

        l.get(left).next = null;


    }

  
}
