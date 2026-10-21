class Solution {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0,new LinkedList<>());

        return res;
    }

    public void dfs(int[] nums, int start, List<Integer> path)
    {
        if(start == nums.length)
        {
            res.add(new LinkedList<>(path));
            return;
        }

        path.add(nums[start]);
        dfs(nums,start + 1,path);
        path.remove(path.size() - 1);

        dfs(nums,start + 1,path);
    }
}
