class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        List<String> path = new ArrayList<>();
        dfs(s,0,path);

        return res;
    }

    public void dfs(String s, int index, List<String> path)
    {   
        System.out.println("dfs called with index: " + index + ", path: " + path);

        if(index > s.length())
        {
            return;
        }

        if(index == s.length())
        {
            res.add(new ArrayList<>(path));
            return;
        }

        int leftLen = s.length() - index;

        for(int i = 0; i < leftLen; i ++)
        {
            if(isPalindrome(s.substring(index,index + i + 1)))
            {
                path.add(s.substring(index,index + i + 1));
                dfs(s,index + i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s)
    {
        if(s.length() == 1 || s.length() == 0)
        {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

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
