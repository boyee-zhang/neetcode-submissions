class Solution {
    class Node{
        int x;
        int y;
        public Node(int col, int row)
        {
            x = col;
            y = row;
        }
    }
    int INF = 2147483647;
    public void islandsAndTreasure(int[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;

        Deque<Node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[row][col];

        for(int i = 0; i < row; i ++)
        {
            for(int j = 0; j < col; j ++)
            {
                if(grid[i][j] == 0)
                {
                    q.add(new Node(j,i));
                    visited[i][j] = true;
                }
            }
        }

        int steps = 1;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty())
        {
            int size = q.size();

            for(int i = 0; i < size; i ++)
            {
                Node cur = q.poll();

                for(int[] dir : dirs)
                {
                    int nextX = dir[0] + cur.x;
                    int nextY = dir[1] + cur.y;

                    if(nextX >= 0 && nextX < col && nextY >= 0 && nextY < row && grid[nextY][nextX] == INF)
                    {
                        grid[nextY][nextX] = steps;
                        q.add(new Node(nextX,nextY));
                        visited[nextY][nextX] = true;
                    }
                }
            }
            steps ++;
        }
    }
}
