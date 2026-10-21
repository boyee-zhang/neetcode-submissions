class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //validate input
        if(s1.length() > s2.length())
        {
            return false;
        }
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> windows = new HashMap<>();

        for(char c : s1.toCharArray())
        {
            map1.put(c,map1.getOrDefault(c,0) + 1);
        }

        int left = 0;

        for(int right = 0; right < s1.length(); right ++)
        {
            char c = s2.charAt(right);
            windows.put(c,windows.getOrDefault(c,0) + 1);
        }

        int count = 0;
        for(char c : map1.keySet())
        {
            if(windows.containsKey(c) && windows.get(c) >= map1.get(c))
            {
                count ++;
            }
        }

        if(count == s1.length())
        {
            return true;
        }
        System.out.println("s1 length :" + s1.length());
        System.out.println("s1 map :" + map1);
        System.out.println("inital windows situation :" + windows);
        System.out.println("inital count : " + count);

        for(int right = s1.length(); right < s2.length(); right ++)
        {
            char c = s2.charAt(right);
            windows.put(c,windows.getOrDefault(c,0) + 1);
            windows.put(s2.charAt(left),windows.get(s2.charAt(left)) - 1);

            if(map1.containsKey(s2.charAt(left)) && windows.get(s2.charAt(left)).intValue() < map1.get(s2.charAt(left)).intValue())
            {
                count --;
            }
            if(map1.containsKey(c) && map1.get(c).equals(windows.get(c)))
            {
                count ++;
            }

            if(count == map1.size())
            {
                return true;
            }
            left ++;
        }
        System.out.println("final windows situation :" + windows);
        System.out.println("final count : " + count);
        return false;
        
    }
}
