class Solution {
    public boolean isPalindrome(String s) {
        
        // clean data   

        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray())
        {
            if(Character.isLetterOrDigit(c))
            {
                sb.append(c);
            }
        }

        int left = 0;
        int right = sb.length() - 1;

        String cleanedData = sb.toString().toLowerCase();

        System.out.println(cleanedData);
        
        while(left <= right)
        {
            if(cleanedData.charAt(left) != cleanedData.charAt(right))
            {
                return false;
            }

            left ++;
            right --;
        }

        return true;
    }
}
