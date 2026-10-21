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
    HashMap<Integer,Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i ++)    
        {
            map.put(inorder[i],i);
        }

        return dfs(preorder,inorder,0,preorder.length - 1,0,inorder.length - 1);
    }

    public TreeNode dfs(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd)
    {
        if(preStart < 0 || inStart < 0 || preStart > preEnd || inStart > inEnd || preEnd >= preorder.length|| inEnd >= inorder.length)
        {
            return null;
        }

        TreeNode root = new TreeNode (preorder[preStart]);

        int inLocation = map.get(preorder[preStart]);
        int leftLen = inLocation - inStart;
        
        System.out.println(leftLen);

        root.left = dfs(preorder,inorder,preStart + 1, preStart + leftLen,inStart,inLocation - 1);
        root.right = dfs(preorder,inorder,preStart + leftLen + 1,preEnd,inLocation + 1, inEnd);

        return root;
    }
}
