class Solution {
    public int lengthOfLongestSubstring(String s) {
        // keep a windows to track how many character in this scale 
        // if we find a duplicated character occur, narrow left pointer otherwise we increase right pointer and 

        int max = 0;
        int left = 0;
        int n = s.length();

        HashMap<Character,Integer> map = new HashMap<>();

        for(int right = 0; right < n; right ++)
        {   
            char c = s.charAt(right);

            if(map.containsKey(c) && map.get(c) != -1)
            {
                int index = map.get(c);

                //state check 

                while(left < n && left <= index)
                {   
                    char leftChar = s.charAt(left);
                    map.put(leftChar, -1);
                    left ++;
                }                
            }

            map.put(c,right);
            max = Math.max(right - left + 1, max);
        }

        return max;
    }
}
