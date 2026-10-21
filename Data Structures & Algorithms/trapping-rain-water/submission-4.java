class Solution {
    public int trap(int[] height) {
        
        if(height.length == 1)
        {
            return 0;
        }

        int n = height.length;
        int res = 0;

        int[] leftMost = new int [n + 1];
        int[] rightMost = new int[n + 1];

        leftMost[0] = height[0];
        for(int i = 1; i < n - 1; i ++)
        {
            leftMost[i] = Math.max(leftMost[i - 1], height[i]);
        }

        rightMost[n - 1] = height[n - 1];

        for(int i = n - 2; i >= 0; i --)
        {
            rightMost[i] = Math.max(rightMost[i + 1],height[i]);
        }

        for(int i = 0; i < n; i ++)
        {
            int leftMax = 0;
            int rightMax = 0;

            //find leftMax 
            
            leftMax = leftMost[i];

            rightMax = rightMost[i];

            res += Math.max(0,Math.min(leftMax,rightMax) - height[i]);
            // System.out.printf("current leftMax %d and rightMax %d ",leftMax,rightMax);
            // System.out.printf("current i = %d could hold %d water \n",i,Math.max(0,Math.max(leftMax,rightMax) - height[i]));
        }

        return res;
    }
}
