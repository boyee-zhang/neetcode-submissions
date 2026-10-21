class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        return dfs(nums,0,target);
    }

    public int dfs(int[] nums, int start, int target)
    {
        if(target == 0 && start == nums.length)
        {
            return 1;
        }
        else if (target != 0 && start == nums.length)
        {
            return 0;
        }

        if(start > nums.length)
        {
            return 0;
        }

        // two option 
        
        // System.out.println("current sum : " + sum);

        int ways = 0;
        ways += dfs(nums,start + 1,target - nums[start]);
        ways += dfs(nums,start + 1,target + nums[start]);

        return ways;
    }
}
