class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int max = 0;

        return dfs(nums,0,-1);
        
    }

    public int dfs(int[] nums, int start, int lastChoose)
    {
        if(start >= nums.length)
        {
            return 0;
        }

        // two options 
        
        if(lastChoose == -1)
        {   
            int skip = dfs(nums,start + 1, lastChoose);
            int choose = 1 + dfs(nums, start + 1, start);
            return Math.max(skip,choose);
        }

        if(nums[start] > nums[lastChoose])
        {   
            int skip = dfs(nums,start + 1, lastChoose);
            int choose = 1 + dfs(nums, start + 1, start);
            return Math.max(skip,choose);
        }
        else
        {
            return dfs(nums,start + 1,lastChoose);
        }
    }
}
