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

                if(right + 1 < n && nums[right] == nums[right + 1])
                {   
                    right --;
                    continue;
                }

                if(nums[left] + nums[right] > target)
                {
                    right --;
                }
                else if (nums[left] + nums[right] < target)
                {
                    left ++;
                }
                else
                {
                    List<Integer> path = new LinkedList<>();

                    path.add(nums[i]);
                    path.add(nums[left]);
                    path.add(nums[right]);

                    res.add(path);
                    left ++;
                    right --;
                }
            }
        }

        return res;
    }
}
