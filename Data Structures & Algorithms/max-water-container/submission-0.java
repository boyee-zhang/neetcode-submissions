class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;

        int left = 0; 
        int right = n - 1;
        int maxArea = 0;
        while(left < right)
        {
            int y = Math.min(heights[left],heights[right]);
            int x = right - left;

            maxArea = Math.max(maxArea, x * y);
            
            if(heights[left] > heights[right])
            {
                right --;
            }
            else
            {
                left ++;
            }
        }

        return maxArea;
    }
}
