class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] memo = new int [cost.length];
        Arrays.fill(memo,-1);

        return Math.min(dfs(cost,0,memo), dfs(cost,1,memo));
    }

    private int dfs(int[] cost, int index, int[] memo)
    {
        if(index >= cost.length)
        {
            return 0;
        }

        if(memo[index] != -1)
        {
            return memo[index];
        }

        memo[index] = cost[index] + Math.min(dfs(cost,index + 1,memo) , dfs(cost, index + 2,memo));

        return memo[index];
    }
}
