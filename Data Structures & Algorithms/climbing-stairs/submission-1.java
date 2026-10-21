class Solution {
    public int climbStairs(int n) {
        return dfs(n);
    }

    private int dfs(int n)
    {
        if(n == 1 || n == 2)
        {
            return n;
        }
        if(n < 0)
        {
            return 0;
        }

        return dfs(n - 1) + dfs(n - 2);
    }
}
