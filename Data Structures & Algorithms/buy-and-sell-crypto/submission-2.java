class Solution {
    public int maxProfit(int[] prices) {
        
        int maxProfit = 0;
        int lowestBuy = Integer.MAX_VALUE;

        for(int p : prices)
        {
            maxProfit = Math.max(maxProfit, p - lowestBuy);
            lowestBuy = Math.min(p, lowestBuy);
        }

        return maxProfit;
    }
}
