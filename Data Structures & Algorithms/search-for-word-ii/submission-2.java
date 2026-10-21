class Solution {
    class TrieNode
    {   
        boolean isEnd;
        TrieNode[] children = new TrieNode[26];
        String str;
    }

    class Trie{


        private TrieNode parent;
        public Trie()
        {
            parent = new TrieNode();
        }

        public void add(String s)
        {   
            TrieNode cur = parent;
            for(char c : s.toCharArray())
            {
                int index = c - 'a';

                if(cur.children[index] == null)
                {
                    cur.children[index] = new TrieNode();
                }

                cur = cur.children[index];
            }

            cur.isEnd = true;
            cur.str = s;
        }

        public boolean containsWord(String s)
        {
            TrieNode cur = parent;

            for(char c : s.toCharArray())
            {
                int index = c - 'a';

                if(cur.children[index] == null)
                {
                    return false;
                }

                cur = cur.children[index];
            }

            return cur.isEnd;
        }

        public boolean containsPrefix(String s)
        {
            TrieNode cur = parent;

            for(char c : s.toCharArray())
            {
                int index = c - 'a';

                if(cur.children[index] == null)
                {
                    return false;
                }

                cur = cur.children[index];
            }

            return true;
        }
    }

    
    List<String> res = new LinkedList<>();
    Trie t = new Trie();

    public List<String> findWords(char[][] board, String[] words) {
        HashSet<String> set = new HashSet<>();

        for(String word : words)
        {   
            t.add(word);
        }

        int row = board.length;
        int col = board[0].length;

        for(int i = 0; i < row; i ++)
        {
            for(int j = 0; j < col; j ++)
            {   
                int index = board[i][j] - 'a';
                if(t.parent.children[index] != null)
                {
                    dfs(board,new boolean [row][col], j ,i, t.parent.children[index]);
                }
            }
        }

        return res;
    }

    public void dfs(char[][] board, boolean[][] visited, int x, int y, TrieNode node)
    {
        if(x < 0 || x>= board[0].length || y < 0 || y >= board.length || visited[y][x])
        {
            return;
        }
        
        if(node.isEnd)
        {
            node.isEnd = false;
            res.add(node.str);
        }

        visited[y][x] = true;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        for(int[] dir : dirs)
        {
            int nx = dir[0] + x;
            int ny = dir[1] + y;
            
            if(nx < 0 || nx >= board[0].length || ny < 0 || ny >= board.length)
            {
                continue;
            }

            if(node.children[board[ny][nx] - 'a'] != null)
            {
                dfs(board,visited,nx,ny,node.children[board[ny][nx] - 'a']);
            }
        }
        
        visited[y][x] = false;
    }
}
