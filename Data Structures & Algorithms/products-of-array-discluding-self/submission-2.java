class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        //自己没发现，但是看答案提示了 prefix and suffix 
        int n = nums.length;
        int[] prefix = new int [n + 1];
        int[] suffix = new int [n + 1];

        prefix[0] = 1;

        for(int i = 1; i < n + 1; i ++)
        {
            prefix[i] = nums[i - 1] * prefix[i - 1];
        }


        suffix[n - 1] = 1;

        for(int i = n - 1; i >= 1; i --)
        {
            suffix[i - 1] = suffix[i] * nums[i];
        }
        
        int[] res = new int [n];

        for(int i = 0; i < n ; i ++)
        {
            res[i] = prefix[i] * suffix[i];
        }

        return res;
    }
}  
