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
    time complextiy : O(N)
    time consume : more than 40 mins 但是我上头了

    最卡住我的是 我没意识到 这个node里的 val 可以一致 太坑了
*/
public class Codec {

    //general idea is to convert this root to a String which consist of two part: 
    // first part -> preorder String
    // second part -> inorder String
    // finally  convert this two String to two list and use this list to build a tree

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder preorderStr = new StringBuilder();
        StringBuilder inorderStr = new StringBuilder();

        preorder(root,preorderStr);
        inorder(root,inorderStr);

        //preorderStr.append(inorderStr);

        return preorderStr.toString() + "|" + inorderStr.toString();
    }

    public void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,"); // 用 "#" 表示空节点
            return;
        }
        sb.append(root.val).append(","); // 添加分隔符
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    public void inorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        inorder(root.left, sb);
        sb.append(root.val).append(","); // 添加分隔符
        inorder(root.right, sb);
    }


    //Data consiste two part
    // preorder String + inorder String

    // Decodes your encoded data to tree.

    //Map<Integer,Integer> map = new HashMap<>();
    Map<Integer, List<Integer>> map = new HashMap<>();

    public TreeNode deserialize(String data) {

        System.out.println(data);

        String[] strs = data.split("\\|");
        if(strs.length < 2)
        {
            return null;
        }

        String[] preorder = strs[0].split(",");
        String[] inorder = strs[1].split(",");

        List<Integer> preorderArray = new ArrayList<>();
        List<Integer> inorderArray = new ArrayList<>();
        
        for(String str : preorder)
        {
            if(!str.isEmpty() && !str.equals("#"))
            preorderArray.add(Integer.valueOf(str));
        }

        for(String str : inorder)
        {
            if(!str.isEmpty() && !str.equals("#"))
            {
                inorderArray.add(Integer.valueOf(str));
            }
        }

        // for(int i = 0 ; i < inorderArray.size(); i++)
        // {
        //     map.put(inorderArray.get(i),i);
        // }
        
        for (int i = 0; i < inorderArray.size(); i++) {
            map.computeIfAbsent(inorderArray.get(i), k -> new ArrayList<>()).add(i);
        }

        boolean[] used = new boolean[inorderArray.size()];

        return buildTree(preorderArray,inorderArray, 0,preorderArray.size() - 1, 0,inorderArray.size() - 1,used);
    }

    public TreeNode buildTree(List<Integer> preorder,List<Integer> inorder,int preLeft,int preRight, int inLeft, int inRight,boolean[] used)
    {
        if(preLeft > preRight || inLeft > inRight)
        {
            return null;
        }

        int curVal = preorder.get(preLeft);
        TreeNode node = new TreeNode(curVal);

        // List<Integer> indices = map.get(curVal);
        // if (indices == null || indices.isEmpty()) {
        //     return null;
        // }
        int inPosition = 0 ;

        for(int i = 0 ; i < inorder.size(); i ++)
        {
            if(inorder.get(i) == preorder.get(preLeft) && !used[i])
            {
                inPosition = i;
                used[i] = true;
            }
        }
        //int inPosition = map.get(curVal);
        int len = inPosition - inLeft;
        
        node.left = buildTree(preorder,inorder,preLeft + 1, preLeft + len,inLeft,inPosition - 1,used);
        node.right = buildTree(preorder,inorder,preLeft + len + 1,preRight,inPosition + 1,inRight,used);

        return node;
    }
}
