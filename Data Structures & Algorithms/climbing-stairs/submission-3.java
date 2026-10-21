class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo,-1);
        dfs(n,memo);
        for(int i = 0; i < memo.length; i ++)
        {
            System.out.println(memo[i]);
        }
        return memo[memo.length - 1];
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
