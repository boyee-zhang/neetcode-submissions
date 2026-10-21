class Solution {
    public boolean exist(char[][] board, String word) {
        
        //validate input 

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0 ; i < m; i ++)
        {
            for(int j = 0 ; j < n; j ++)
            {
                if(board[i][j] == word.charAt(0))
                {
                    if(dfs(board,visited,word,j,i,0))
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board,boolean[][] visited,String word, int x, int y,int index)
    {   
        if(index == word.length())
        {
            return true;
        }

        //validate input
        if(x < 0 || x >= board[0].length || y < 0 || y >= board.length || visited[y][x])
        {
            return false;
        }

   
        if(board[y][x] != word.charAt(index))
        {
            return false;
        }

        visited[y][x] = true;

        //recursive search next position
        if(dfs(board,visited,word,x + 1,y,index + 1 ) ||
            dfs(board,visited,word,x - 1,y,index + 1) ||
            dfs(board,visited,word,x,y + 1,index + 1) ||
            dfs(board,visited,word,x,y - 1,index + 1))
            {
                return true;
            }

        visited[y][x] = false;
        return false;
    }
}
