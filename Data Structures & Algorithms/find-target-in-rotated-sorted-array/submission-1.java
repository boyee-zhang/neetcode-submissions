class Solution {
    public int search(int[] nums, int target) {
        //validate input 
        

        // should be a binary search question 
        int left = 0;
        int right = nums.length - 1;

        while(left <= right)
        {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target)
            {
                // find the target 
                return mid;
            }
            else if(nums[mid] >= nums[left]) //  left part is ordered
            {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            else
            {
                if (target > nums[mid] && target <= nums[right])
                {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
            }
        }

        return -1;
    }
}
