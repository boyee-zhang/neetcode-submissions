class Solution {
    public void setZeroes(int[][] matrix) {
        

        // find each zero and spread from this point to another other points
        int m = matrix.length;
        int n = matrix[0].length;

        int[] rows = new int [m];
        int[] cols = new int [n];

        for(int i = 0; i < m; i ++)
        {
            for(int j = 0; j < n; j ++)
            {
                if(matrix[i][j] == 0)
                {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }

        for(int i = 0 ; i < m; i ++)
        {   
            if(rows[i] == 1)
            Arrays.fill(matrix[i],0);
        }

        for(int i = 0; i < n; i ++)
        {
            if(cols[i] == 1)
            {
                for(int row = 0; row < m; row ++)
                {
                    matrix[row][i] = 0;
                }
            }
        }

        
    }
}
