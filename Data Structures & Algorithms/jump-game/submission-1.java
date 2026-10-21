class Solution {
    public boolean canJump(int[] nums) {
        
        return dfs(nums,0);
    }

    public boolean dfs(int[] nums, int index)
    {
        if(index >= nums.length - 1)
        {
            return true;
        }

        int steps = nums[index];

        for(int i = 1; i <= steps; i ++)
        {
            if(dfs(nums,index + i))
            {
                return true;
            }
        }

        return false;
    }
}
