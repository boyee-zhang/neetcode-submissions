class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String,List<String>> map = new HashMap<>();

        List<List<String>> res = new LinkedList<>();

        // if(strs.length == 0)
        // {
        //     return res;
        // }

        
        for(String str : strs)
        {   
            System.out.println(str);

            char[] chars = str.toCharArray();

            Arrays.sort(chars);

            String orderedString = new String(chars);

            if(map.containsKey(orderedString))
            {
                map.get(orderedString).add(str);
            }
            else
            {
                map.put(orderedString,new LinkedList<>());
                map.get(orderedString).add(str);
            }
        }

        for(Map.Entry<String,List<String>> entry : map.entrySet())
        {   
            res.add(entry.getValue());
        }

        return res;
    }
}
