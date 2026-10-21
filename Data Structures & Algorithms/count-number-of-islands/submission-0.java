class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int islandNum = 0;

        for(int i = 0; i < m; i ++)
        {
            for(int j = 0; j < n; j ++)
            {
                if(grid[i][j] == '1' && !visited[i][j])
                {
                    dfs(grid,visited,j,i);
                    islandNum ++;
                }
            }
        }

        return islandNum;

    }

    public void dfs(char[][] grid, boolean[][] visited,int x ,int y)
    {
        // validate boundary and visited 
        if(x < 0 || x >= grid[0].length || y < 0 || y >= grid.length || visited[y][x] || grid[y][x] != '1')
        {
            return;
        }

        visited[y][x] = true;

        int[][] directions = {{1,0}, {-1,0}, {0,1} , {0,-1}};
        
        for(int[] direction : directions)
        {
            int nextX = x + direction[0];
            int nextY = y + direction[1];

            dfs(grid,visited,nextX,nextY);
        }
        // dfs(grid,visited,x + 1, y);
        // dfs(grid, visited, x - 1 , y);
        // dfs(grid, visited, x , y + 1);
        // dfs(grid, visited, x , y - 1);
    }
}
