class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> path = new ArrayList<>();

        dfs(nums,0,path);
        return res;
    }

        public void dfs(int[] nums, int index, List<Integer> path) {
        res.add(new ArrayList<>(path));  // 每次递归都加入当前 path 作为子集

        for (int i = index; i < nums.length; i++) {  // ✅ 关键：从 index 开始，防止重复选取
            path.add(nums[i]);
            dfs(nums, i + 1, path);  // ✅ 递归进入下一层，i + 1 确保不重复选择
            path.remove(path.size() - 1);  // ✅ 回溯，撤销当前选择
        }

        //dfs(nums,index + 1,path);
    }
}
