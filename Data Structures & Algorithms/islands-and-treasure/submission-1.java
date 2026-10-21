class Solution {
    //use dfs
     private int INF = 2147483647;

    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < m; i ++)
        {
            for(int j = 0; j < n; j ++)
            {
                if(grid[i][j] == 0)
                {
                    queue.add(new int[] {j,i});
                }
            }
        }

        int count = 0;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!queue.isEmpty())
        {
            int[] curr = queue.poll();
            
            int y = curr[1];
            int x = curr[0];

            for(int[] direction : directions)
            {
                int nx = x + direction[0];
                int ny = y + direction[1];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m && grid[ny][nx] == INF)
                {
                    grid[ny][nx] = grid[y][x] + 1;
                    queue.add(new int[] {nx,ny});
                }
            }
        }
    }

    
}
