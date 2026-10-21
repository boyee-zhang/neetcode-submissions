class Solution {
    public int numIslands(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for(int i = 0; i < m; i ++)
        {
            for(int j = 0; j < n; j ++)
            {
                if(grid[i][j] == '1')
                {
                    dfs(grid,j,i);
                    count ++;
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int x, int y)
    {
        if(x < 0 || x >= grid[0].length || y < 0 || y >= grid.length)
        {
            return;
        }

        if(grid[y][x] == '1')
        {
            grid[y][x] = '0';

            dfs(grid,x + 1,y);
        dfs(grid,x - 1,y);
        dfs(grid,x, y + 1);
        dfs(grid,x, y - 1);
        }

        
    }
}
