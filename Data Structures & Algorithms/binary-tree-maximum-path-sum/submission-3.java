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
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        pathSum(root);

        return max;
    }

    public int pathSum(TreeNode node)
    {
        if(node == null)
        {
            return 0;
        }

        int left = 0;

        if(pathSum(node.left) > 0)
        {
            left = pathSum(node.left);
        }
        else
        {
            left = 0;
        }

        int right = 0;
        if(pathSum(node.right) > 0)
        {
            right = pathSum(node.right);
        }

        max = Math.max(node.val + left + right, max);

        return node.val + Math.max(left,right);
    }
}
