class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        // indicate if this postion could go to Pacif or Atlantic oceacn
        List<List<Integer>> res = new ArrayList<>();;

        //indicate if could visit
        boolean[][] p_table = new boolean [m][n];
        boolean[][] a_table = new boolean [m][n];

        for(int i = 0 ; i < n; i ++)
        {
            p_table[0][i] = true;
            a_table[m - 1][i] = true;
        }
        for(int i = 0 ; i < m; i ++)
        {
            p_table[i][0] = true;
            a_table[i][n - 1] = true;
        }

        for(int i = 0 ; i < n; i ++) dfs(heights,i, 0, p_table);
        for(int i = 0 ; i < m; i ++) dfs(heights,0, i, p_table);

        for(int i = 0; i < n; i ++)  dfs(heights,i, m - 1, a_table);
        for(int i = 0 ; i < m; i ++) dfs(heights,n - 1, i, a_table);
        
        for(int i = 0 ; i < m; i ++)
        {
            for(int j = 0 ; j < n ; j ++){
                if(a_table[i][j] && p_table[i][j]){
                    List<Integer> position = new ArrayList<>();
                    position.add(i);
                    position.add(j);
                    res.add(new ArrayList<>(position));
                }
            }
        }

        return res;
    }  

    public void dfs(int[][] heights,int x, int y, boolean[][] table)
    {
        //validation 
        if(x < 0 || x >= heights[0].length || y < 0 || y >= heights.length)
        {
            return;
        }

        table [y][x] = true;
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        for(int[] direction : directions)
        {
            int nextX = x + direction[0];
            int nextY = y + direction[1];

            if(nextX < 0 || nextX >= heights[0].length || nextY < 0 || nextY >= heights.length || heights[nextY][nextX] <  heights[y][x] || table[nextY][nextX])
            {
                continue;
            }
            dfs(heights, nextX, nextY, table);
        }
    }
}
