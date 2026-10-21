class Solution {
    public int trap(int[] height) {
        
        if(height.length == 1)
        {
            return 0;
        }

        int n = height.length;
        int res = 0;

        for(int i = 0; i < n; i ++)
        {
            int leftMax = 0;
            int rightMax = 0;

            //find leftMax 
            for(int j = i - 1; j >= 0; j --)
            {
                leftMax = Math.max(leftMax,height[j]);
            }

            for(int j = i + 1; j < n ; j ++)
            {
                rightMax = Math.max(rightMax,height[j]);
            }

            res += Math.max(0,Math.min(leftMax,rightMax) - height[i]);
            System.out.printf("current leftMax %d and rightMax %d ",leftMax,rightMax);
            System.out.printf("current i = %d could hold %d water \n",i,Math.max(0,Math.max(leftMax,rightMax) - height[i]));
        }

        return res;
    }
}
