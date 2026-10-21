class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int top = 0;
        int left = 0;
        int right = matrix[0].length - 1;
        int down  = matrix.length - 1;

        List<Integer> res = new LinkedList<>();
        while(true)
        {   
            for(int i = left; i <= right; i ++) res.add(matrix[top][i]);
            top ++;
            if(top > down) break;
            
            for(int i = top; i <= down; i ++) res.add(matrix[i][right]);
            right --;
            if(right < left) break;

            for(int i = right; i >= left; i --) res.add(matrix[down][i]);
            down --;
            if(down < top) break;

            for(int i = down; i >= top; i --) res.add(matrix[i][left]);
            left ++;
            if(left > right) break;
        }

        return res;
    }

    
}
