class Solution {
    ArrayList<List<Integer>> res = new ArrayList<>();   

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums,new boolean [nums.length],new ArrayList<>());
        return res;
    }

    /*
        1. if this element have been selected, it would not be seleted in this recursive process
        2. every elements is unique
        3. return size always equal the nums array size
        4. return set never be duplicated in return list
    */


    public void dfs(int[] nums, boolean[] used, ArrayList<Integer> path)
    {
        if(path.size() == nums.length)
        {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i ++)
        {
            if(!used[i])
            {
                used[i] = true;
                path.add(nums[i]);
                dfs(nums,used,path);
                used[i] =false;
                path.removeLast();
            }
        }
        
    }
}
