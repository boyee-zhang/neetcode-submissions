class Solution {
    HashSet<String> dict;

    Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        dict = new HashSet<>(wordDict);
        memo = new Boolean [s.length() + 1];

        
        return dfs(s,0);

    }

    public boolean dfs(String s, int start)
    {
        if(start >= s.length())
        {   
            memo[start] = true;
            return true;
        }

        if(memo[start] != null)
        {
            return memo[start];
        }

        for(int i = start; i < s.length(); i ++)
        {
            String sub = s.substring(start,i + 1);

            if(dict.contains(sub) && dfs(s,i + 1))
            {   
                memo[start] = true;
                return true;
            }
        }

        memo[start] = false;
        return false;
    }
}
