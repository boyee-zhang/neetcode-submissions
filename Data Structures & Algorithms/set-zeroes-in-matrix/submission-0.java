class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] used = new boolean [m][n];

        for(int i = 0; i < m; i ++)
        {
            for(int j = 0; j < n ; j ++)
            {
                if(matrix[i][j] == 0)
                {
                    used[i][j] = true;
                }
            }
        }

        for(int i = 0; i < m; i ++)
        {
            for(int j = 0; j < n ; j ++)
            {
                if(used[i][j])
                {
                    for(int x = 0; x < n; x++)
                    {
                        matrix[i][x] = 0;
                    }
                    
                    for(int y = 0; y < m ; y ++)
                    {
                        matrix[y][j] = 0;
                    }
                }
            }
        }
    }
}
