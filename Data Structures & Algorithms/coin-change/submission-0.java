class Solution {
    int[][] memo;
    public int coinChange(int[] coins, int amount) {
        
        memo = new int [coins.length + 1][amount + 1];

        for(int i = 0; i < memo.length; i ++)
        {
            Arrays.fill(memo[i], -1);
        }

        return dfs(coins,0,amount) == 1000000 ? -1 : dfs(coins,0,amount) ;
    }

    public int dfs(int[] coins, int index, int amount)
    {
        if(index >= coins.length)
        {
            return 1000000;
        }

        if(amount < 0)
        {
            return 1000000;
        }

        if(amount == 0)
        {   
            memo[index][amount] = 0;
            return 0;
        }

        if(memo[index][amount] != -1)
        {
            return memo[index][amount];
        }

        int count = 0;

        int skip = dfs(coins,index + 1, amount);
        int choose = 1 + dfs(coins,index, amount - coins[index]);

        memo[index][amount] = Math.min(skip,choose);
        return memo[index][amount];
    }
}
