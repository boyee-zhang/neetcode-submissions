class Solution {
    public int maxArea(int[] heights) {
        

        int n = heights.length;
        int max = 0;

        int left = 0;
        int right = n - 1;

        while(left <= right)
        {
            int currentHeight = Math.min(heights[left], heights[right]);
            max = Math.max(max, (right - left) * currentHeight);

            
            if(heights[left] < heights[right])
            {
                left ++;
            }
            else
            {
                right --;
            }
        }

        return max;
    }
}
