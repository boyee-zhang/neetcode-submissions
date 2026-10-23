class Solution {
    public int numIslands(char[][] grid) {
        /*
            find how many block of "1" in this grid
            - if meet '1', we can count plus one and transform this "1" to "0"

            invariant:
                - only move to next "1" and not visited grid in one round
                 
        */

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean [m][n];
        int count = 0;

        for(int i = 0; i < m; i ++)
        {
            for(int j = 0; j < n; j ++)
            {
                if(grid[i][j] == '1')
                {
                    dfs(grid,j,i,visited);
                    count ++;
                }
            }
        }


        return count;
    }

    public void dfs(char[][] grid, int x ,int y, boolean[][] visited)
    {
        if(x >= grid[0].length|| x < 0 || y >= grid.length || y < 0|| visited[y][x] || grid[y][x] != '1')
        {
            return;
        }

        grid[y][x] = '0';
        visited[y][x] = true;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        for(int[] dir : dirs)
        {
            int nx = dir[0] + x;
            int ny = dir[1] + y;

            dfs(grid,nx,ny,visited);
        }
    }
}
