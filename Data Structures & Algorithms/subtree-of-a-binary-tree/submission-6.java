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

 /*
    time complexity O(n)
    time consume 10mins

    稍微难了我一下， 第一次 submission 11/21
    稍微做了点其他事回来 写不出来了 
 */

class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        boolean cur = false;
       if(root == null && subRoot != null)
       {
            return false;
       }
       else if(subRoot == null)
       {
            return true;
       }
       else if(root.val == subRoot.val)
       {
            cur =  isSameTree(root,subRoot);
       }
        return cur || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    private boolean isSameTree(TreeNode t1,TreeNode t2)
    {
        if(t1 == null && t2 == null)
        {
            return true;
        }
        else if(t1 == null && t2 != null)
        {
            return false;
        }
        else if(t1 != null && t2 == null)
        {
            return false;
        }
        else if(t1.val != t2.val)
        {
            return false;
        }
        else
        {
            return isSameTree(t1.left,t2.left) && isSameTree(t1.right,t2.right);
        }
    }

}
