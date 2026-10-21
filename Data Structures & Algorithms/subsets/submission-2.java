class Solution {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        res.add(new LinkedList<>());
        dfs(nums,0, new LinkedList<>());

        return res;
    }

    public void dfs(int[] nums,int start,List<Integer> path)
    {

        if(start >= nums.length)
        {
            return;
        }

        // two options 

        dfs(nums,start + 1,path);

        path.add(nums[start]);
        res.add(new LinkedList<>(path));
        dfs(nums,start + 1,path);
        path.remove(path.size() - 1);
    }
}
