class Solution {
    //obvious it's a bfs
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int numOfFresh = 0;
        for(int i = 0 ; i < m; i ++)
        {
            for(int j = 0 ; j < n; j ++)
            {
                if(grid[i][j] == 2)
                {
                    queue.add(new int[] {j,i});
                }
                if(grid[i][j] == 1)
                {
                    numOfFresh ++;
                }
            }
        }
        
        if(numOfFresh == 0)
        {
            return 0;
        }
        System.out.println("num of fresh fruit " + numOfFresh);
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0, -1}};
        int count = 0;

        while(!queue.isEmpty())
        {   

            int size = queue.size();
            
            for(int i = 0 ; i < size; i ++)
            {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];

                for(int[] direction : directions)
                {
                    int nx = x + direction[0];
                    int ny = y + direction[1];

                    if(nx >= 0 && nx < n && ny >= 0 && ny < m && grid[ny][nx] == 1)
                    {
                        grid[ny][nx] = 2;
                        queue.add(new int[]{nx,ny});
                        numOfFresh --;
                    }
                }
            }
            
            count ++;
        }
        System.out.println(" After num of fresh fruit " + numOfFresh);

        return numOfFresh == 0 ? count - 1 : -1;
    }
}
