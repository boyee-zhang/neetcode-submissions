class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean [n][m];

        for(int i = 0; i < n; i ++)
        {
            for(int j = 0; j < m; j ++)
            {
                if(dfs(board,j,i,visited,word,0))
                {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, int x, int y, boolean[][] visited, String word, int index)
    {
        if(index == word.length())
        {
            return true;
        }

        if(x >= board[0].length || x < 0 || y >= board.length || y < 0 || visited[y][x])
        {
            return false;
        }

        if(word.charAt(index) != board[y][x])
        {
            return false;
        }

        int[][] dirs = {{1,0},{-1,0} ,{0,1},{0,-1}};
        visited[y][x] = true;
        for(int[] dir : dirs)
        {
            int nx = dir[0] + x;
            int ny = dir[1] + y;

            if(dfs(board,nx,ny,visited,word, index + 1))
            {
                return true;
            }
        }

        visited[y][x] = false;

        return false;
    }


}
