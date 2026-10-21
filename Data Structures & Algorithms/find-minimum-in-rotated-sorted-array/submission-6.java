class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int ans = nums[0];
        
        while(left <= right)
        {
            int mid = (right - left) / 2 + left;

            if(nums[mid] <= nums[right])
            {
                ans = Math.min(ans, nums[mid]);
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
            }
        }

        return ans;
    }
}
