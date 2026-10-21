class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(new StringBuilder(),n,n));

        while(!queue.isEmpty())
        {
            Node curr = queue.poll();

            if(curr.left < 0 || curr.right < 0)
            {
                continue;
            }
            if(curr.left == 0 && curr.right == 0)
            {   
                res.add(curr.sb.toString());
                continue;
            }
            
            // reach to next position 
            if(curr.left > 0)
            {
                queue.add(new Node(new StringBuilder(curr.sb).append("("),curr.left - 1, curr.right));
            }

            if(curr.right > curr.left)
            {
                queue.add(new Node(new StringBuilder(curr.sb).append(")"),curr.left,curr.right - 1));
            }
        }

        return res;
    }
    class Node{
        int left;
        int right;
        StringBuilder sb;

        public Node(StringBuilder sb, int left, int right)
        {
            this.sb = sb;
            this.left = left;
            this.right = right;
        }
    }

    public void dfs(List<String> res,int leftP, int rightP,StringBuilder sb)
    {
        if(leftP > rightP)
        {
            return;
        }
        if(leftP < 0 || rightP < 0)
        {
            return;
        }
        if(leftP == 0 && rightP == 0)
        {
            res.add(sb.toString());
            return;
        }

        sb.append("(");
        dfs(res,leftP - 1, rightP, sb);
        sb.setLength(sb.length() - 1);

        sb.append(")");
        dfs(res,leftP,rightP - 1, sb);
        sb.setLength(sb.length() - 1);
    }
}
