class Solution {
    private Map<Character, List<Character>> adj = new HashMap<>();
    private Map<Character, Boolean> visited = new HashMap<>(); // true: visiting, false: visited
    private StringBuilder res = new StringBuilder();
    private int[] states = new int [26];
    public String foreignDictionary(String[] words) {
        // 1. 初始化所有出现的字母（重要：没出现连边关系的字母也要在图中）
        for (String w : words) {
            for (char c : w.toCharArray()) {
                adj.putIfAbsent(c, new ArrayList<>());
            }
        }

        // 2. 建图：对比相邻单词
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i+1];
            // 坑点检查：如果 abc 排在 ab 前面，非法
            if (w1.length() > w2.length() && w1.startsWith(w2)) return "";
            
            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if (c1 != c2) {
                    adj.get(c1).add(c2); // 发现 c1 在 c2 前面
                    break; // 只要找到第一对不同，后面就不用看了
                }
            }
        }

        // 3. DFS 拓扑排序
        for (Character c : adj.keySet()) {
            if (hasCycle(c)) return ""; // 如果 DFS 发现环，返回空
        }

        // 4. 注意：DFS 得到的是逆序，所以要反转
        return res.reverse().toString();
    }

    private boolean hasCycle(char c) {
        int index = c - 'a';
        if(states[index] == 1)
        {
            return true;
        }

        if(states[index] == 2)
        {
            return false;
        }


        states[index] = 1;
        
        for(char next : adj.get(c))
        {
            if(c == next)
            {
                continue;
            }

            if(hasCycle(next))
            {
                return true;
            }
        }

        states[index] = 2;
        res.append(c);
        return false;
    }
}