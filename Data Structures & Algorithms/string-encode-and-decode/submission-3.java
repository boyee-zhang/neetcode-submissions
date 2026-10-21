class Solution {
    public String encode(List<String> strs) {
            if(strs.isEmpty()) return "";

            StringBuilder sb = new StringBuilder();

            for(String str : strs)
            {
                sb.append(str.length()).append("#").append(str);
            }
            
            return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        
        int i = 0;
        while(i < str.length()){
            int j = 0;
            for(j = i; j < str.length(); j ++)
            {
                if(str.charAt(j) == '#')
                {
                    break;
                }
            }

            int length = Integer.parseInt(str.substring(i,j));

            res.add(str.substring(j + 1, j + 1 + length));
            i = j + 1 + length;
        }
            
        return res;
    }
}
