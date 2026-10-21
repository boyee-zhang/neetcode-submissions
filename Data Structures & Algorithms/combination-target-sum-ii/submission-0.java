class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);

        dfs(candidates,0,target,path);

        return res;
    }

    public void dfs(int[] nums, int index, int target,List<Integer> path)
    {   
        if(target < 0 )
        {
            return;
        }
        if(target == 0)
        {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = index; i < nums.length; i ++)
        {   
            if(i > index && nums[i] == nums[i - 1])
            {
                continue;
            }
            path.add(nums[i]);
            dfs(nums,i + 1,target - nums[i],path);
            path.remove(path.size() - 1);
        }
    }
}
