class Solution {
        public int numDecodings(String s) {
        // 如果字符串为空或以'0'开头，返回0
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        
        return dfs(s, 0);  // 从位置0开始进行DFS
    }

    // 递归 DFS 函数
    private int dfs(String s, int index) {
        if (index == s.length()) {
            return 1;
        }

        if (s.charAt(index) == '0') {
            return 0;
        }

        int ways = dfs(s, index + 1);

        if(index + 1 < s.length())
        {
            if (s.charAt(index) == '1' || (s.charAt(index) == '2' && s.charAt(index + 1) <= '6')) {
            ways += dfs(s, index + 2);
        }
        }
        
        return ways;
        }
}
