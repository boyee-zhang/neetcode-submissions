class Solution {
    List<List<String>> res = new LinkedList<>();
    public List<List<String>> partition(String s) {
        dfs(s,0,new LinkedList<>());

        return res;
    }

    public void dfs(String s, int start,List<String> path)
    {
        if(start == s.length())
        {
            res.add(new LinkedList<>(path));
            // path.remove(path.size() - 1);
            return;
        }

        for(int i = start; i < s.length(); i ++)
        {
            if(isValid(s,start, i))
            {   

                path.add(s.substring(start, i + 1));
                System.out.println("current path " + path);

                dfs(s,i + 1,path);
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean isValid(String s, int left, int right)
    {   
        if(right < left)
        {
            return false;
        }

        while(left <= right)
        {
            if(s.charAt(left) != s.charAt(right))
            {
                return false;
            }

            left ++;
            right --;
        }

        return true;
    }
}
