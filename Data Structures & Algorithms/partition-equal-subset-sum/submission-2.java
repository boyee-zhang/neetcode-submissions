class Solution {
    public boolean canPartition(int[] nums) {
        
        int n = nums.length;

        int sum = 0;
        for(int num : nums)
        {
            sum += num;
        }

        if(sum % 2 != 0)
        {
            return false;
        }

        sum = sum / 2;


        return findTarget(nums,0, sum);
    }

    public boolean findTarget(int[] nums,int start, int target)
    {
        if(target == 0)
        {
            return true;
        }
        if(target < 0)
        {
            return false;
        }
        if(start >= nums.length)
        {
            return false;
        }

        boolean skip = findTarget(nums,start + 1, target);
        boolean choose = findTarget(nums,start + 1, target - nums[start]);

        return skip || choose;
    }
}
