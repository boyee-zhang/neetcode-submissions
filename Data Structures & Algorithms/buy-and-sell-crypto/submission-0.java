class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int minVal = 100;

        for(int price : prices)
        {
            if(price < minVal)
            {
                minVal = price;
            }
            else
            {
                max = Math.max(price - minVal, max);
            }
        }

        return max;
    }
}
