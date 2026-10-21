class Solution {
    private List<Integer> sizes = new ArrayList<>();
    public String encode(List<String> strs) {
            if(strs.isEmpty()) return "";

            StringBuilder sb = new StringBuilder();
            //sizes.clear();  
            //System.out.println(strs.size());
            for(String str : strs)
            {
                sizes.add(str.length());
                sb.append(str);
            }
            System.out.println(sizes);
           // System.out.println(sb);

            return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        if(sizes.isEmpty()) return res;
        

        int start = 0;
        for(int size : sizes)
        {   
            if(size == 0)
            {
                res.add("");
            }
            else
            {
                res.add(str.substring(start,start + size));
            }
            
            start = start + size;
        }

        return res;
    }
}
