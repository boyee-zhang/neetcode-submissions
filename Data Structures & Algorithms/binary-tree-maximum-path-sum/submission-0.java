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
        currentPathMax(root);
        return max;
    }

    public int currentPathMax(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }

        int leftGain = Math.max(currentPathMax(root.left),0);
        int rightGain = Math.max(currentPathMax(root.right),0);

        int currentVal = root.val + leftGain + rightGain;

        max = Math.max(currentVal, max);

        return root.val + Math.max(leftGain,rightGain);
    }
}
