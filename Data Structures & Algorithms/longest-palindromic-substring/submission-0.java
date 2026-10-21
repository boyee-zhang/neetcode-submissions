class Solution {
    //central expand
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1) return "";

        int leftIndex = 0;
        int maxLen = 0;

        for(int i = 0; i < s.length(); i ++)
        {
            //odd length
           int l = i;
           int r = i;
           while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r))
           {
                if(r - l + 1 > maxLen)
                {
                    leftIndex = l;
                    maxLen = r - l + 1;
                }
                l--;
                r++;
           }

           l = i;
           r = i + 1;
           while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r))
           {
                if(r - l + 1 > maxLen)
                {
                    leftIndex = l;
                    maxLen = r - l + 1;
                }
                l--;
                r++;
           }
        }

        return s.substring(leftIndex,leftIndex + maxLen);
    }

}
