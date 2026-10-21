class Solution {
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        HashMap<Character,List<Character>> map = new HashMap<>();
        
        //validate input 
        if(digits == null || digits.length() == 0)
        {
            return res;
        }

        //build graph
        map.put('2', Arrays.asList('a','b','c'));
        map.put('3',Arrays.asList('d','e','f'));
        map.put('4',Arrays.asList('g','h','i'));
        map.put('5',Arrays.asList('j','k','l'));
        map.put('6',Arrays.asList('m','n','o'));
        map.put('7',Arrays.asList('p','q','r','s'));
        map.put('8',Arrays.asList('t','u','v'));
        map.put('9',Arrays.asList('w','x','y','z'));

        dfs(new StringBuilder(), digits, 0, map);

        return res;
    }

    public void dfs(StringBuilder sb, String digits, int index,HashMap<Character,List<Character>> map)
    {
        if(index == digits.length())
        {
            res.add(sb.toString());
            return;
        }

        for(Character cur : map.get(digits.charAt(index)))
        {
            sb.append(cur);
            dfs(sb,digits,index + 1, map);
            sb.setLength(sb.length() - 1);
        }
    }
}
