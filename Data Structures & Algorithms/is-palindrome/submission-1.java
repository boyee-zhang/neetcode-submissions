class Solution {
    public boolean isPalindrome(String s) {
        //validate input
        if(s.length() == 1)
        {
            return true;
        }

        
        // Do i need to validate spaces？ yes and I need to  convert upper to lower case
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int n = s.length();
        int left = 0;
        int right = n - 1;

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
