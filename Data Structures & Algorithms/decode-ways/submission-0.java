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
        // 如果已遍历到字符串末尾，说明找到了一种有效的解码方式
        if (index == s.length()) {
            return 1;
        }

        // 如果当前位置的字符是'0'，则无法解码，返回0
        if (s.charAt(index) == '0') {
            return 0;
        }

        // 先解码一个字符
        int ways = dfs(s, index + 1);

        // 然后尝试解码两个字符，前提是两个字符构成合法的数字（即在1到26之间）
        if (index + 1 < s.length() && Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            ways += dfs(s, index + 2);
        }

        return ways;
        }
}
