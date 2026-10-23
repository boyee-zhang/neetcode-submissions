class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*
            require: 
             - find a longest substring(contiguous sequence) without  DUPLICATED char
            
            invariant:
            1. keep a [i,j] substring, without duplicated char -> need a container to quickly look up if existed duplicated element
            2. compare each substring length to get the maximum length
        */


        int maxLen = 0;

        int slow = 0;
        int fast = 0;
        Set<Character> windows = new HashSet<>();

        int len = s.length();

        while(slow <= fast && fast < len)
        {   
            char rightChar = s.charAt(fast);

            if(windows.isEmpty() || !windows.contains(rightChar))
            {
                windows.add(rightChar);
            }
            else
            {

                while(slow < fast && s.charAt(slow) != rightChar)
                {
                    windows.remove(s.charAt(slow));
                    slow ++;
                }
                
                slow ++;
                windows.add(rightChar);
            }

            // System.out.println("current set" + windows);
            // System.out.println("left : " + slow + " right " + fast);
            maxLen = Math.max(maxLen,fast - slow + 1);
            fast ++;
        }

        return maxLen;
    }
}
