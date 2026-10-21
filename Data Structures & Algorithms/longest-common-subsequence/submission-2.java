class Solution {
    int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        
        int n = text1.length();
        int m = text2.length();

        memo = new int [n + 1][m + 1];
        for(int i = 0; i < memo.length; i ++)
        {
            Arrays.fill(memo[i], -1);
        }

        return dfs(text1,text2,0,0);
    }

    public int dfs(String s1, String s2,int i, int j)
    {
        if(i >= s1.length() || j >= s2.length())
        {   
            // memo[i][j] = 0;
            return 0;
        }

        if(memo[i][j] != -1)
        {
            return memo[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j))
        {   
            memo[i][j] = 1 + dfs(s1,s2,i + 1, j + 1);
            return memo[i][j];
        }
        else
        {   
            memo[i][j] = Math.max(dfs(s1,s2,i + 1,j + 1), Math.max(dfs(s1,s2,i + 1,j),dfs(s1,s2,i,j + 1))) ;
            return memo[i][j];
        }
    }
}
