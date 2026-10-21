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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "#";

        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        // Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return dfs(q);
    }

    public TreeNode dfs(Queue<String> q)
    {
        String node = q.poll();

        if(node.equals("#"))
        {
            return null;
        }

        TreeNode root = new TreeNode (Integer.valueOf(node));

        root.left = dfs(q);
        root.right = dfs(q);

        return root;
    }
}
