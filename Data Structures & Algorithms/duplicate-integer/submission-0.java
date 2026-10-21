class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums)
        {   

            //state check 
            if(set.contains(num))
            {
                return true;
            }
            set.add(num);
        }

        return false;
    }
}