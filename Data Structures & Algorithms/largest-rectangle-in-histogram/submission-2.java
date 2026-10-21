class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int n = heights.length;
        int[] leftFirstLower = new int[n];  // 存放索引
        int[] rightFirstLower = new int[n]; // 存放索引

        // 1. 预处理左侧第一个更小的索引
        leftFirstLower[0] = -1; // 哨兵：左边没有比它矮的
        for (int i = 1; i < n; i++) {
            int p = i - 1;
            while(p >= 0 && heights[i] < heights[p])
            {
                p --;
            }
            leftFirstLower[i] = p;
        }

        // 2. 预处理右侧第一个更小的索引
        rightFirstLower[n - 1] = n; // 哨兵：右边没有比它矮的
        for (int i = n - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < n && heights[p] >= heights[i]) {
                p = rightFirstLower[p];
            }
            rightFirstLower[i] = p;
        }

        // 3. 计算最大面积
        int maxArea = 0;
        for (int i = 0; i < n; i++) {            
            int width = rightFirstLower[i] - leftFirstLower[i] - 1;
            maxArea = Math.max(maxArea, heights[i] * width);
            System.out.printf("current i %d, left %d and right %d, Area : %d \n", i,leftFirstLower[i],rightFirstLower[i],maxArea);

            // 习惯性 Print 调试
            // System.out.printf("Index %d: H=%d, L_Bound=%d, R_Bound=%d, W=%d, Area=%d\n", 
            //                   i, heights[i], leftFirstLower[i], rightFirstLower[i], width, heights[i] * width);
        }

        return maxArea;
    }
}
