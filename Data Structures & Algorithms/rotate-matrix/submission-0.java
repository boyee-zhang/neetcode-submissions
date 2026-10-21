class Solution {
    /*
        general idea    
        1. start from the most outside cycle
            1.1 rotate the top row to the rightmost col
            1.2 rotate the right col to the bottom row
            1.3 ..
        2. go deeply inside
    */
    public void rotate(int[][] matrix) {
        int n = matrix[0].length;

        int[] temp = new int [n];

        int l = 0;
        int r = n - 1;

        while(l < r)
        {
            for(int i =0; i < r -l ; i ++)
            {
                int top =  l;
                int bottom = r;

                int topLeft = matrix[top][l + i];

                //move bottom left into top left
                matrix[top][l + i] = matrix[bottom - i][l];
                matrix[bottom - i][l] = matrix[bottom][r - i];

                //move top right into bottom righ 
                matrix[bottom][r - i] = matrix[top + i][r];

                //move top left into top right
                matrix[top + i][r] = topLeft;
            }
            r --;
            l ++;
        }
    }

    public void print(int[][] nums)
    {
        int m = nums.length;
        int n = nums[0].length;
        for(int i = 0; i < m; i ++)
        {
            System.out.println(nums[i]);
        }
    }
}
