class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*
            require: 
             - find a longest substring(contiguous sequence) without  DUPLICATED char
            
            invariant:
            1. keep a [i,j] substring, without duplicated char -> need a container to quickly look up if existed duplicated element -> hashamp
            2. compare each substring length to get the maximum length
        */


        int maxLen = 0;

        int slow = 0;
        int fast = 0;
        Map<Character,Integer> windows = new HashMap<>();

        int len = s.length();

        while(slow <= fast && fast < len)
        {   
            char rightChar = s.charAt(fast);

            if(windows.isEmpty() || !windows.containsKey(rightChar))
            {
                windows.put(rightChar,fast);
            }
            else
            {
                
                int duplicatePointer = windows.get(rightChar);

                while(slow < fast && slow < duplicatePointer)
                {
                    windows.remove(s.charAt(slow));
                    slow ++;
                }
                
                slow ++;
                windows.put(rightChar,fast);
            }

            maxLen = Math.max(maxLen,fast - slow + 1);
            fast ++;
        }

        return maxLen;
    }
}
