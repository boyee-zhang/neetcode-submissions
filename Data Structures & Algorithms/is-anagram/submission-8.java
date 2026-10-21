class Solution {
    public boolean isAnagram(String s, String t) {

        char[] s1 = new char [26];
        char[] s2 = new char [26];

        for(char c : s.toCharArray())
        {
            int index = c - 'a';

            s1[index]  ++;
        }

        for(char c : t.toCharArray())
        {
            int index = c - 'a';

            s2[index] ++;
        }

        for(int i = 0; i < 26; i ++)
        {
            if(s1[i] != s2[i])
            {
                return false;
            }
        }

        return true;
    }
}
