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

        return buildTreeHelper(preorder,inorder,0,preorder.length - 1,0, inorder.length - 1);
    }

    public TreeNode buildTreeHelper(int[] preorder,int[] inorder,int preLeft, int preRight,int inLeft,int inRight)
    {   
    
        if(preLeft > preRight || inLeft > inRight)
        {
            return null;
        }

        TreeNode node = new TreeNode(preorder[preLeft]);
        int inPosition = map.get(preorder[preLeft]);
        int leftLength = inPosition - inLeft;

        node.left = buildTreeHelper(preorder,inorder,preLeft + 1, preLeft + leftLength ,inLeft,inPosition - 1);
        node.right = buildTreeHelper(preorder,inorder,preLeft + 1 + leftLength ,preRight, inPosition + 1, inRight);

        return node;
    }
}
