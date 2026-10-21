class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo,-1);

        return dfs(nums,0,memo);
    }

    private int dfs(int[] nums, int index, int[] memo)
    {
        if(index >= nums.length)
        {
            return 0;
        }

        if(memo[index] != -1)
        {
            return memo[index];
        }
        int option1 = dfs(nums,index + 2,memo) + nums[index];
        int option2 = dfs(nums,index + 1,memo);

        memo[index] = Math.max(option1,option2);
        return memo[index];
    }
}
