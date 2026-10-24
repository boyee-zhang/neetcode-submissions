class Solution {

    int[] memo = new int [10001];

    public int coinChange(int[] coins, int amount) {
        
        if(amount == 0)
        {
            return 0;
        }
        
        if(amount < 0)
        {
            return -1;
        }

        if(memo[amount] != 0)
        {
            return memo[amount];
        }
        // what's this issue pattern ?
        // what is this problem's invariant ?

        /*
            invariant :
                - coninChange function return the least number of coins need 
                - children coins need == coinChange(current mount - currentCoin)
                - if return conins < 0 means it not able to find a way to make up amount 
                - otherwise it return the least amount of conins
        */

        int min = Integer.MAX_VALUE;
    

        for(int coin : coins)
        {
            int next = coinChange(coins, amount - coin);

            if(next >= 0)
            {
                min = Math.min(min,next + 1);
                memo[amount] = min;
            }
        }

        if(min == Integer.MAX_VALUE) memo[amount] = -1;
        return memo[amount];
    }

}
