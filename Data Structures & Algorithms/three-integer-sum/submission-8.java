class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;

        for(int i = 0; i < n - 2; i ++)
        {
            int fixedNum = nums[i];
            if(i > 0 && nums[i] == nums[i - 1])
            {
                continue;
            }
            //we are looking for a val could equal -fiexNum

            int left = i + 1;
            int right = n - 1;

            while(left < right)
            {
                int curNum = nums[left] + nums[right];

                if(curNum + fixedNum == 0)
                {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // System.out.println("hello here 1");

                    while(left + 1 < right && nums[left] == nums[left + 1])
                    {
                        System.out.println("hello here");
                        left ++;
                    }
                    
                    while(right - 1 > left && nums[right] == nums[right - 1])
                    {
                        right --;
                    }

                    left ++;
                    right --;
  
                }
                else if(curNum + fixedNum < 0)
                {
                    left ++;
                } 
                else
                {
                    right --;
                }
            }
        }

        // List<List<Integer>> res = new ArrayList<>();

        // for(List<Integer> l : ans)
        // {
        //     res.add(l);
        // }

        return ans;
    }
}
