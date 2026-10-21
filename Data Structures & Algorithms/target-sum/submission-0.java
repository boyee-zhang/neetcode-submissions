class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        return dfs(nums,0,target,0);
    }

    public int dfs(int[] nums, int start, int target,int sum)
    {
        if(target == sum && start == nums.length)
        {
            return 1;
        }
        else if (target != sum && start == nums.length)
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
        ways += dfs(nums,start + 1,target ,sum + nums[start]);
        ways += dfs(nums,start + 1,target,sum - nums[start]);

        return ways;
    }
}
