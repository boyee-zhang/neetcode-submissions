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
    TreeNode prev = null;
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new LinkedList<>();
        dfs(root,res);
        return res.get(k - 1);
    }

    public void dfs(TreeNode root,List<Integer> bst)
    {
        if(root == null)
        {
            return;
        }
        dfs(root.left,bst);
        bst.add(root.val);
        dfs(root.right,bst);
    }
}
