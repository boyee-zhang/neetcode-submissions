class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid[0].length;
        int m = grid.length;
        boolean[][] visited = new boolean[m][n];
        int maxArea = 0;

        for(int i = 0 ; i < m; i ++)
        {
            for(int j = 0 ; j < n; j ++)
            {
                if(grid[i][j] == 1 && !visited[i][j])
                {
                    maxArea = Math.max(maxArea, dfs(grid,j,i,visited));
                }
            }
        }

        return maxArea;
    }

    public int dfs(int[][] grid, int x, int y, boolean[][] visited)
    {
        if(x < 0 || x >= grid[0].length || y < 0 || y >= grid.length || visited[y][x] || grid[y][x] == 0)
        {
            return 0;
        }

        int ways = 1;
        visited[y][x] = true;

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        for(int[] direction : directions)
        {
            int nx = x + direction[0];
            int ny = y + direction[1];

            if(nx >= 0 && nx < grid[0].length && ny >= 0 && ny < grid.length && !visited[ny][nx] && grid[y][x] == 1)
            {
                ways += dfs(grid,nx,ny,visited);
            }
        }

        return ways;
    }
}
