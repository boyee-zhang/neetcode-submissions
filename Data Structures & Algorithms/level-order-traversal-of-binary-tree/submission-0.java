/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null)
        {
            return res;
        }      

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);

        while(!deque.isEmpty())
        {   
            int size = deque.size();
            List<Integer> path = new LinkedList<>();

            for(int i = 0 ; i < size; i ++)
            {
                TreeNode cur = deque.pollFirst();
                path.add(cur.val);

                if(cur.left != null)
                {
                    deque.add(cur.left);
                }
                if(cur.right != null)
                {
                    deque.add(cur.right);
                }
            }
            res.add(path);
        }

        return res;
    }
}
