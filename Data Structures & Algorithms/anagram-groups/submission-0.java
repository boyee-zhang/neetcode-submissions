class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();

        for(String str : strs)
        {
            char[] orderedstr = str.toCharArray();
            Arrays.sort(orderedstr);
            String keys = new String(orderedstr);

            map.putIfAbsent(keys,new ArrayList<>());
            map.get(keys).add(str);
        }

        for(List<String> list : map.values())
        {
            res.add(list);
        }

        return res;
    }
}
