class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int left = 0;
        int right = n - 1;

        int maxArea = 0;

        while(left < right)
        {

            int curArea = (right - left) * Math.min(heights[left],heights[right]);

            maxArea = Math.max(maxArea, curArea);

            if(heights[left] < heights[right])
            {
                left ++;
            }
            else
            {
                right --;
            }
        }


        return maxArea;
    }
}
