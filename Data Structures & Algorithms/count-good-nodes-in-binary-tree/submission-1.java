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
    List<Integer> res = new ArrayList<>();

    public int goodNodes(TreeNode root) {
        dfs(root,Integer.MIN_VALUE);

        System.out.println(res);
        return res.size();
    }

    public void dfs(TreeNode root, int num)
    {
        if(root == null)
        {
            return;
        }

        if(root.val >= num)
        {
            res.add(root.val);
        }

        dfs(root.left, Math.max(num, root.val));
        dfs(root.right,Math.max(num, root.val));


    }
}
