class Solution {
    public int maxSubArray(int[] nums) {
        
        int n = nums.length;
        int[] prefix = new int [n + 1];

        for(int i = 0; i < n; i ++)
        {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int max = nums[0];

        for(int i = 0; i < n + 1; i ++)
        {
            for(int j = i + 1; j < n + 1; j ++)
            {   
                max = Math.max(max, prefix[j] - prefix[i]);
            }
        }

        return max;
    }
}
