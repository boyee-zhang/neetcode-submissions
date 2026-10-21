class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean [nums.length];
        List<Integer> path = new ArrayList<>();

        dfs(nums,visited,path);
        return res;
    }

    public void dfs(int[] nums, boolean[] visited, List<Integer> path)
    {
        if(path.size() == nums.length)
        {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0 ; i < nums.length; i ++)
        {
            if(!visited[i])
            {
                path.add(nums[i]);
                visited[i] = true;
                dfs(nums,visited,path);
                visited[i] = false;
                path.remove(path.size() - 1);
            }
            
        }

    }
}
