class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int res = nums[0];

        while(left <= right)
        {
            if(nums[left] < nums[right])
            {
                res = Math.min(nums[left], res);
                break;
            }
            
            int mid = (left + right) / 2;

            if(nums[left] <= nums[mid])
            {
                res = Math.min(nums[left],res);
                left = mid + 1;
            }
            else 
            {
                res = Math.min(nums[mid],res);
                right = mid - 1;
            }
            
        }

        return res;
    }
}
