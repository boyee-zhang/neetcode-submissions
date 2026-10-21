class Solution {
    public int characterReplacement(String s, int k) {
        // what's the invariant 
        // keep one windows to at most contain k distinct elements
        // store the distinct elements number, if we reach a k + 1 elements should delete the most left one element 
        // len - maxFreq < k

        int left = 0;
        int n = s.length();
        int longest = 0;
        int maxFreq = 0;

        HashMap<Character,Integer> counts = new HashMap<>();

        for(int right = 0; right < n; right ++)
        {   
            char c = s.charAt(right);

            counts.put(c, counts.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, counts.get(c));
            
            while(right - left + 1 - maxFreq > k)
            {
                //update left boundary 
                char leftChar = s.charAt(left);

                counts.put(leftChar, counts.get(leftChar) - 1);

                left ++;
            }

            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }
}
