class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer>path = new ArrayList<>();

        backTracking(nums,target,0,res,path);

        return res;
    }
    public void backTracking (int[] nums, int target,int startIndex,List<List<Integer>> res, List<Integer>path)
    {
        //base
        if(target == 0)
        {
            res.add(new ArrayList<>(path));
            return;
        }
        if(target < 0)
        {
            return;
        }

        //divide 
        for(int i = startIndex; i < nums.length; i ++)
        {
            path.add(nums[i]);
            backTracking(nums,target - nums[i], i, res, path);
            path.remove(path.size() - 1);
        }

    }
}
