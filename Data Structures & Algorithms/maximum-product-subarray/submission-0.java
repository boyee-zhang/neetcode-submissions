class Solution {
    public int maxProduct(int[] nums) {
        int maxSoFar = nums[0];
        int maxCurr = nums[0];
        int minCurr = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            
            if (n < 0) {
                int temp = maxCurr;
                maxCurr = minCurr;
                minCurr = temp;
            }

            maxCurr = Math.max(n, maxCurr * n);
            minCurr = Math.min(n, minCurr * n);

            maxSoFar = Math.max(maxSoFar, maxCurr);
        }
        return maxSoFar;
    }
}
