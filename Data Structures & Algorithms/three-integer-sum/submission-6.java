class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);

        int n = nums.length;
        for(int i = 0; i < n; i ++)
        {
            int target = -nums[i];

            if(i > 0 && nums[i] == nums[i - 1])
            {
                continue;
            }


            int left = i + 1;
            int right = n - 1;

            while(left < right)
            {   
                // if(left > 0 && nums[left] == nums[left - 1])
                // {   
                //     left ++;
                //     continue;
                // }

                int sum = nums[left] + nums[right];       

                if(sum > target)
                {
                    right --;
                }
                else if (sum < target)
                {
                    left ++;
                }
                else
                {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left ++;
                    right --;
                }
            }
        }

        return res;
    }
}
