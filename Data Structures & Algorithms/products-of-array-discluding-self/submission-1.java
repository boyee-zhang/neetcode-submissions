class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        
        int[] leftPre = new int[n];
        int[] rightPre = new int[n];

        leftPre[0] = 1;
        for(int i = 1; i < n; i ++)
        {
            leftPre[i] = leftPre[i - 1] * nums[i - 1];
        }

        rightPre[n - 1] = 1;
        for(int i = n - 2; i >= 0; i --)
        {
            rightPre[i] = rightPre[i + 1] * nums[i + 1];
        }

        for(int i = 0; i < n; i ++)
        {
            output[i] = leftPre[i] * rightPre[i];
        }

        return output;
    }
}  
