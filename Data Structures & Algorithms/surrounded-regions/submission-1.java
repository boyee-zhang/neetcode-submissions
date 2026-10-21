class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        if(m == 0) return;
        int n = board[0].length;

        boolean[][] flag = new boolean[m][n];
        
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < m; i ++)
        {
            if(board[i][0] == 'O')
            {
                queue.add(new int[]{0,i});
                flag[i][0] = true;
            }
            if(board[i][n - 1] == 'O')
            {
                queue.add(new int[] {n - 1,i});
                flag[i][n - 1] = true;
            }
        }

        for(int i = 0 ; i < n; i ++)
        {
            if(board[0][i] == 'O')
            {
                queue.add(new int[] {i,0});
                flag[0][i] = true;
            }
            if(board[m - 1][i] == 'O')
            {
                queue.add(new int[]{i,m - 1});
                flag[m - 1][i] = true;
            }
        }
        
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        while(!queue.isEmpty())
        {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];

            for(int[] direction : directions)
            {
                int nx = x + direction[0];
                int ny = y + direction[1];
                
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && !flag[ny][nx] && board[ny][nx] == 'O')
                {
                    flag[ny][nx] = true;
                    queue.add(new int[] {nx,ny});
                }
            }
        }

        for(int i = 0 ; i < m; i ++)
        {
            for(int j = 0 ; j < n ; j ++)
            {
                if(flag[i][j])
                {
                    board[i][j] = 'O';
                }
                else
                {
                    board[i][j] = 'X';
                }
            }
        }

    }
}
