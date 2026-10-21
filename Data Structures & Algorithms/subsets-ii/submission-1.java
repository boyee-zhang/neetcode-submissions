class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        dfs(nums,new LinkedList<>(), 0);
        return res;
    }

    public void dfs(int[] nums, List<Integer> path, int start)
    {   
        

        if(start >= nums.length)
        {
            res.add(new LinkedList<>(path));
            return;
        }


  
        path.add(nums[start]);
        dfs(nums,path,start + 1);
        path.remove(path.size() - 1);
    

        int next = start + 1;

        while(next < nums.length && nums[start] == nums[next])
        {
            next ++;
        }
        dfs(nums,path,next);
    }
}
