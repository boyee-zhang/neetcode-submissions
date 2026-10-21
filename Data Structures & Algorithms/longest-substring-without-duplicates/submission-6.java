class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character,Integer> map = new HashMap<>();  //character <-> index
        int left = 0;
        // int right = 0;
        int n = s.length();
        int longestLen = 0;

        for(int right = 0; right < n; right ++)
        {
            char c = s.charAt(right);

            if(map.containsKey(c))
            {
                left = Math.max(map.get(c) + 1, left);
            }
    
            longestLen = Math.max(longestLen, right - left + 1);
            map.put(c,right);
            // System.out.println(longestLen + " and current left " + left + " right " + right + " current  len : " + (right - left + 1));
        }

        return longestLen;
    }
}
