class Solution {
    HashSet<String> set;
    Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        memo = new Boolean [s.length() + 1];

        return dfs(s,0);
    }

    public boolean dfs(String s, int start)
    {
        if(start >= s.length())
        {
            return true;
        }

        if(memo[start] != null)
        {
            return memo[start];
        }

        for(int i = start; i < s.length(); i ++)
        {
            if(set.contains(s.substring(start,i + 1)) && dfs(s, i + 1))
            {   
                memo[start] = true;
                return true;
            }
        }

        memo[start] = false;
        return false;
    }
}
