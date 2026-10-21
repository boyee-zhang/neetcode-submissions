class Solution {
    Set<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums,target,new ArrayList<>(),0);

        List<List<Integer>> res = new ArrayList<>();

        for(List<Integer> l : set)
        {
            res.add(l);
        }

        return res;
    }

    public void dfs(int[] nums, int target, List<Integer> path, int start)
    {
        if(target < 0)
        {
            return;
        }

        if(target == 0)
        {

            System.out.println("current target " + target + " current path " + path);
            // Collections.sort(path);
            set.add(new ArrayList<>(path));
            return;
        }

        for(int i = start; i < nums.length; i ++)
        {
            if(target - nums[i] >= 0)
            {
                path.add(nums[i]);
                dfs(nums,target - nums[i], path,i);
                path.remove(path.size() - 1);
            }

            // dfs(nums,target,path);
        }

    }
}
