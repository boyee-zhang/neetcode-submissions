class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
        {
            return nums[0];
        }
        int[] memo1 = new int[nums.length];
        int[] memo2 = new int[nums.length];

        Arrays.fill(memo1,-1);
        Arrays.fill(memo2,-1);

        // for(int i = 0; i < memo.length; i ++)
        // {
        //     System.out.println(memo[i]);
        // }
        return Math.max(dfs(nums,0,nums.length - 2,memo1) , dfs(nums,1,nums.length - 1,memo2));        
    }

    private int dfs(int[] nums, int start, int end,int[] memo)
    {
        if(start > end)
        {
            return 0;
        }
        if(memo[start] != -1)
        {
            return memo[start];
        }

        int option1 = dfs(nums,start + 1,end, memo);
        int option2 = dfs(nums,start + 2,end, memo) + nums[start];

        memo[start] = Math.max(option1,option2);

        return memo[start];
    }
}
