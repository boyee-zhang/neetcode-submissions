class Solution {
    public int maxArea(int[] heights) {
        

        int n = heights.length;
        int max = 0;

        for(int i = 0; i < n; i ++)
        {
            for(int j = i + 1; j < n; j ++)
            {
                max = Math.max(max,(j - i) * Math.min(heights[i],heights[j]));
            }
        }

        return max;
    }
}
