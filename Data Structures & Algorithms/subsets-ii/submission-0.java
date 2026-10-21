class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums,0,path);

        return res;
    }

    public void dfs(int[] nums, int index, List<Integer> path)
    {
        res.add(new ArrayList<>(path));

         for(int i = index; i < nums.length; i ++)
         {
            if(i > index && nums[i - 1] == nums[i])
            {
                continue;
            }
            path.add(nums[i]);
            dfs(nums,i + 1,path);
            path.remove(path.size() - 1);
         }
    }

}
