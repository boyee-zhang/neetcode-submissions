class Solution {
    public boolean exist(char[][] board, String word) {
        
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i ++)
        {
            for(int j = 0; j < n; j ++)
            {
                if(dfs(board,j,i,0,word,new boolean[m][n],new StringBuilder()))
                {
                    return true;
                }
            }
        }


        return false;
    }

    public boolean dfs(char[][] board, int x, int y,int index,String word,boolean[][] visited,StringBuilder sb)
    {   
        if(index == word.length())
        {
            return true;
        }
        
        if(x < 0 || x >= board[0].length || y < 0 || y >= board.length || visited[y][x])
        {
            return false;
        }

    

        if(board[y][x] == word.charAt(index))
        {
            int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

            visited[y][x] = true;
            sb.append(board[y][x]);

            System.out.println("x " + x + " y " + y + sb);
            for(int[] dir : dirs)
            {
                int nx = dir[0] + x;
                int ny = dir[1] + y;

                if(dfs(board,nx,ny,index + 1,word,visited,sb))
                {
                    return true;
                }
            }

            sb.setLength(sb.length() - 1);
            visited[y][x] = false;
        }

        return false;
    }
}
