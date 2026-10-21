class Solution {
    public int orangesRotting(int[][] grid) {
        //validate input 
        int freshCount = 0;
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < m; i ++)
        {
            for(int j =0; j < n; j ++)
            {
                if(grid[i][j] == 2)
                {
                    queue.add(new int[]{j,i});
                }
                else if (grid[i][j] == 1)
                {
                    freshCount ++;
                }
            }
        }

        if(freshCount == 0)
        {
            return 0;
        }

        int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
        int mins = 0;

        while(!queue.isEmpty())
        {
            int size = queue.size();

            for(int i = 0; i < size; i ++)
            {
                int[] node = queue.poll();
                int x = node[0];
                int y = node[1];

                for(int[] direction : directions)
                {
                    int nx = x + direction[0];
                    int ny = y + direction[1];

                    if(nx >= 0 && nx < n && ny >= 0 && ny < m && grid[ny][nx] == 1)
                    {
                        queue.add(new int[] {nx,ny});
                        grid[ny][nx] = 2;
                    }
                }
            }

            mins ++;
        }

        for(int i = 0; i < m; i ++)
        {
            for(int j =0; j < n; j ++)
            {
                if(grid[i][j] == 1)
                {
                    return -1;
                }
            }
        }

        return mins - 1;

    }
}
