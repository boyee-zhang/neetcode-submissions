class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo,-1);

        return dfs(n,memo);
    }

    private int dfs(int n,int[] memo)
    {
        if(n == 1 || n == 2)
        {
            memo[n] = n;
            return memo[n];
        }
        if(memo[n] != -1)
        {
            return memo[n];
        }

        if(n < 0)
        {
            return 0;
        }
        memo[n] = dfs(n - 1,memo) + dfs(n - 2,memo);

        return memo[n];
    }
}
