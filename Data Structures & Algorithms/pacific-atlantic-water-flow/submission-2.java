class Solution {

    /*
        general idea
        1. at least one grid, so add the right up grid, add the left bottom grid
        2. check top row and the mostleft col
        3. check the bottom row and the most right col
        4. check inside grid check if could reach to both Pacific nad Atlantic

        
    */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        List<List<Integer>> res = new ArrayList<>();

        boolean[][] canReachP = new boolean [m][n];
        boolean[][] canReachA = new boolean [m][n];

        for(int i = 0; i < n; i ++)
        {
            dfs(heights,i,0,heights[0][i],canReachP);
            dfs(heights,i,m - 1, heights[m - 1][i],canReachA);
        }

        for(int i = 0; i < m; i ++)
        {
            dfs(heights,0,i,heights[i][0],canReachP);
            dfs(heights,n - 1, i, heights[i][n - 1],canReachA);
        }
       
        for(int i = 0; i < m; i ++)
        {
            for(int j = 0; j < n; j ++)
            {
                if(canReachP[i][j] && canReachA[i][j])
                {
                    res.add(Arrays.asList(i,j));
                }
            }
        }

        return res;
    }

    public void dfs(int[][] board, int x, int y, int prevHeight,boolean[][] canReach)
    {
        if(x < 0 || x>= board[0].length || y < 0 || y >= board.length || canReach[y][x] || board[y][x] < prevHeight)
        {
            return;
        }

        canReach[y][x] = true;

        dfs(board,x + 1, y, board[y][x], canReach);
        dfs(board,x - 1, y, board[y][x], canReach);
        dfs(board,x, y + 1, board[y][x], canReach);
        dfs(board,x, y - 1, board[y][x], canReach);
    }
}
