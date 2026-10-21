class Solution {
    public String minWindow(String s, String t) {
        
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();

        int mostLeft = -1;

        for(char c: t.toCharArray())
        {
            map2.put(c,map2.getOrDefault(c, 0) + 1);
        }

        int n = s.length();

        int left = 0;
        int matchNum = 0;
        int min = Integer.MAX_VALUE;
        
        for(int right = 0; right < n; right ++)
        {   
            char cur = s.charAt(right);

            if(map2.containsKey(cur))
            {
                map1.put(cur, map1.getOrDefault(cur,0) + 1);

                if(map2.get(cur) == map1.get(cur))
                {
                    matchNum ++;
                }

            
                while(matchNum == map2.size())
                {   
                    if(right - left + 1 < min)
                    {
                        min = right - left + 1;
                        mostLeft = left;
                    }

                    char delete = s.charAt(left);

                    if(map2.containsKey(delete))
                    {
                        map1.put(delete,map1.get(delete) - 1);
                    }

                    if(map2.containsKey(delete) && map1.get(delete) < map2.get(delete))
                    {
                        matchNum --;
                    }

                    left ++;
                }
            } 
        }


        return mostLeft == -1 ? "" : s.substring(mostLeft,mostLeft + min);
    }
}
