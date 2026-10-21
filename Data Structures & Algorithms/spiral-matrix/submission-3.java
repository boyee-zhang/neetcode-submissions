class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> res = new ArrayList<>();

        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = m - 1;

        while(left <= right && top <= bottom)
        {
            //move left to right
            for(int i = left; i <= right; i ++)
            {
                res.add(matrix[top][i]);
            }
            top ++;

            //move rightTop to rightBottom
            for(int i = top; i <= bottom; i ++)
            {
                res.add(matrix[i][right]);
            }
            right --;
            
             if (left > right || top > bottom) {
                break;
            }
            //move rightBottom to leftBottom
            for(int i = right; i >= left; i --)
            {
                res.add(matrix[bottom][i]);
            }
            bottom --;
            //move rightBottom to leftUp
            for(int i = bottom; i >= top ; i --)
            {
                res.add(matrix[i][left]);
            }
            left ++;
        }

        return res;
    }
}
