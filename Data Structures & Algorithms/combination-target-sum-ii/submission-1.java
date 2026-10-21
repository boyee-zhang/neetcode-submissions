class Solution {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,target, new LinkedList<>(), 0);

        return res;
    }

    public void dfs(int[] nums,int target, List<Integer> path,int start)
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

        path.add(nums[start]);
        dfs(nums, target - nums[start], path, start + 1);
        path.remove(path.size() - 1); // 回溯
        
        int next = start + 1;
        while (next < nums.length && nums[next] == nums[start]) {
            next++;
        }
        dfs(nums, target, path, next); // 直接跳到不一样的数

    }
}
