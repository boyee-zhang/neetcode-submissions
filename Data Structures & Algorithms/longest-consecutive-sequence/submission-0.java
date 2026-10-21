class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums)
        {
            set.add(num);
        }

        int maxLen = 0;
        for(int num : nums)
        
        {
            if(!set.contains(num - 1))
            {
                int start = num;
                int tempLen = 0;
                while(set.contains(start))
                {
                    tempLen ++;
                    start++;
                }
                maxLen = Math.max(maxLen, tempLen);
            }
        }

        return maxLen;
    }
}
