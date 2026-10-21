class Solution {
    int[] memo;
    public int minCostClimbingStairs(int[] cost) {
        memo = new int[cost.length];
        Arrays.fill(memo,-1);

        return Math.min(dfs(cost,0), dfs(cost,1));
    }

    public int dfs(int[] cost, int start)
    {
        if(start >= cost.length)
        {
            return 0;
        }
        
        if(memo[start] != -1)
        {
            return memo[start];
        }
        //two option 

        int option1 = dfs(cost,start + 1) + cost[start];
        int option2 = dfs(cost,start + 2) + cost[start];

        memo[start] = Math.min(option1,option2);
        return memo[start];
    }
}
