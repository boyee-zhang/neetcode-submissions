class Solution {
    public int maxSubArray(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int [n];

        int max = Integer.MAX_VALUE;

        dp[0] = nums[0];
        max = dp[0];

        for(int i = 1; i < n; i ++)
        {
            dp[i] = Math.max(dp[i - 1] + nums[i],nums[i]);

            max = Math.max(dp[i],max);
        }

        return max;
    }
}
