class Solution {

    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();

        for(String str : strs)
        {
            int len = str.length();
            sb.append(len).append(",").append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new LinkedList<>();

        int i = 0;

        while(i < str.length())
        {
            int index = i;

            while(index < str.length() && str.charAt(index) != ',')
            {
                index ++;
            }

            int val = Integer.valueOf(str.substring(i,index));

            res.add(str.substring(index + 1,index + val + 1));

            i = index + val + 1;
        }

        return res;
    }
}
