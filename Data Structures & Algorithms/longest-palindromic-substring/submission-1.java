class Solution {
    public String longestPalindrome(String s) {
        
        int max = 1;
        int maxStart = 0;
        int n = s.length();

        for(int i = 0; i < s.length(); i ++)
        {
            // central is the mid pointer

            int mid = i;
            int left = mid - 1;
            int right = mid + 1;

            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right))
            {

                if(right - left + 1 > max)
                {
                    max = right - left + 1;
                    maxStart = left;
                }
                left --;
                right ++;
            }

            left = mid - 1;
            right = mid;

            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right))
            {
                if(right - left + 1 > max)
                {
                    max = right - left + 1;
                    maxStart = left;
                }

                left --;
                right ++;
            }
        }

        // System.out.println("start" + maxStart + " len " + max);
        return s.substring(maxStart,maxStart + max);
    }
}
