class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        dfs(res,n,n,new StringBuilder());

        return res;
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
