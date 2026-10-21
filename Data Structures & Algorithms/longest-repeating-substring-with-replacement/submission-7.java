class Solution {
    // final 11/22 
    // wrong solution, beacuse I use hashSet but I should use HashMap


    public int characterReplacement(String s, int k) {
        
        //validate input 
        if(s.length() == 1)
        {
            return 1;
        }

        // keep one windows to count how many distinct character , if beyond k, move left

        int left = 0;
        int n = s.length();
        int maxF = 0;
        int maxLen = 0;

        HashMap<Character,Integer> map = new HashMap<>();

        for(int right = 0 ; right < n; right ++)
        {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c,0) + 1);

            maxF = Math.max(maxF,map.get(c));

            //if beyond k 
            while(right - left + 1 - maxF > k)
            {   
                char mostLeft = s.charAt(left);
                map.put(mostLeft,map.get(mostLeft) - 1);
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
