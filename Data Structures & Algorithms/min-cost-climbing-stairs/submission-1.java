class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(dfs(cost,0),dfs(cost,1));
    }

    private int dfs(int[] cost, int index)
    {
        if(index >= cost.length)
        {
            return 0;
        }

        return cost[index] + Math.min(dfs(cost,index + 1), dfs(cost,index + 2));
    }
}
