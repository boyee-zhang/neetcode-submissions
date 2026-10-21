class Solution {
    public int characterReplacement(String s, int k) {
        
        int left = 0;
        int n = s.length();

        // windows should keep a frequency of most element
        // if reach to the k capacity, narrow left pointer, to reduce some element frequencey
        // use a max to store the longest substring length

        Map<Character,Integer> map = new HashMap<>();
        int mostFreq = 0;
        int max = 0;

        for(int right = 0; right < n; right ++)
        {      
            char c = s.charAt(right);

            map.put(c,map.getOrDefault(c,0) + 1);

            if(map.get(c) > mostFreq)
            {
                mostFreq = map.get(c);
            }

            if(right - left + 1 - mostFreq > k) // over the limitation
            {
                map.put(s.charAt(left),map.get(s.charAt(left)) - 1);

                // if(map.get(s.charAt(left)) == 0)
                // {
                //     map.remove(s.charAt(left));
                // }

                left ++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
