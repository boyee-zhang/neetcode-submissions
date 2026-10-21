class Solution {
    public int countSubstrings(String s) {
        
        int n = s.length();
        int count = 0;

        for(int i = 0; i < n; i ++)
        {
            for(int j = i; j < n; j ++)
            {
                if(isPalindromic(s,i,j))
                {
                    count ++;
                }
            }
        }

        return count;
    }

    public boolean isPalindromic(String s, int left, int right)
    {
         
        while(left <= right)
        {
        if(s.charAt(left) != s.charAt(right))
        {
            return false;
        }

        left ++;
        right --;
        }

        return true;
    }
}
