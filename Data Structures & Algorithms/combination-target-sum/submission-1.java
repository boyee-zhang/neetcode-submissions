class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums,target,0, new LinkedList<>());

        return res;
    }

    public void dfs(int[] nums, int target,int start, List<Integer> path)
    {
        if(target == 0)
        {
            res.add(new LinkedList<>(path));
            return;
        }

        if(target < 0)
        {
            return;
        }
        if(start >= nums.length)
        {
            return;
        }

        // two option
        //skip 

        dfs(nums,target,start + 1, path);

        // choose

        path.add(nums[start]);
        dfs(nums,target - nums[start], start, path);
        path.remove(path.size() - 1);
    }
}
