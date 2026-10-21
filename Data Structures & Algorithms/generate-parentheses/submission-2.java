class Solution {
    List<String> res = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n,n,new StringBuilder());

        return res;    
    }

    public void dfs(int left, int right,StringBuilder path)
    {
        if(left == 0 && right == 0)
        {
            res.add(path.toString());
            return;
        }

        if(left < 0 || right < 0)
        {
            return;
        }

        if(right < left)
        {
            return;
        }

        //two option -> put left parenthese or put right parenthese

        //left

        if(left > 0)
        {
            path.append("(");
            dfs(left - 1, right,path);
            path.deleteCharAt(path.length() - 1);
        }

        if(right > 0)
        {
            path.append(")");
            dfs(left, right - 1, path);
            path.deleteCharAt(path.length() - 1);
        }

    }
}
