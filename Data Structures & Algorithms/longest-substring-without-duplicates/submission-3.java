class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 )
        {
            return 0;
        }
        
        HashMap<Character,Integer> map = new HashMap<>();

        int left = 0;
        int len = 1;

        for(int right = 0; right < s.length(); right ++ )
        {   
            
            char curCh = s.charAt(right);
            if(!map.containsKey(curCh))
            {
                map.put(curCh,right);
            }
            else
            {
                // if find some element already exist, we have to remove element from left to right
                left = Math.max(map.get(curCh) + 1,left);
                map.put(curCh,right); 
            } 
            System.out.println(map);
            System.out.println("curent left " + left);
            len = Math.max(len, right - left + 1);

        }

        return len;
    }
}
