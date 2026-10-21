class Solution {
    int[][] totalDistance;
    int[][] reachBuilding;
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Deque<int[]> q = new ArrayDeque<>();
        int building = 0;
        boolean[][] visited = new boolean[m][n];
        totalDistance = new int[m][n];
        reachBuilding = new int[m][n];

        for(int i = 0 ; i < m; i ++)
        {
            for(int j = 0; j < n; j ++)
            {
                if(grid[i][j] == 1)
                {
                    building ++;
                    bfs(grid,j,i);
                }
            }
        }

        int min = Integer.MAX_VALUE;

        // System.out.println(building);

        for(int i = 0 ; i < m ; i ++)
        {
            for(int j = 0; j < n; j ++)
            {
                if(reachBuilding[i][j] == building)
                {
                    // System.out.println("row : " + i + " col : " + j + " count : " + totalDistance[i][j]);
                    min = Math.min(min,totalDistance[i][j]);
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public void bfs (int[][] grid, int col, int row)
    {
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        Deque<int[]> q = new ArrayDeque<>();

        q.add(new int[] {col,row});
        visited[row][col] = true;

        int count = 1;

        while(!q.isEmpty())
        {
            int size = q.size();

            for(int i = 0; i < size; i ++)
            {
                int[] node = q.poll();
                int x = node[0];
                int y = node[1];

                for(int[] dir : dirs)
                {
                    int nx = x + dir[0];
                    int ny = y + dir[1];

                    if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[ny][nx] && grid[ny][nx] == 0)
                    {
                        q.add(new int[] {nx,ny});
                        totalDistance[ny][nx] += count;
                        reachBuilding[ny][nx] ++;

                        visited[ny][nx]= true;
                    }
                }
            }
            count ++;
        }
    }
}
