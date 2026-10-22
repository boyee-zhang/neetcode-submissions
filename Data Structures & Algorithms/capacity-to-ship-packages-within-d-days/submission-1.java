class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // clear find a pivor to match the result 

        int maxWeight = 0;
        int leastWeight = 0;

        for(int w : weights)
        {
            leastWeight = Math.max(leastWeight,w);
            maxWeight += w;
        }

        // this pivot must between [1,maxWeight]

        // System.out.println(leastWeight);

        int left = leastWeight;
        int right = maxWeight;
        int ans = 0;


        while(left <= right)
        {
            int mid = left + (right - left)/ 2;

            System.out.println("right " + right);
            if(capabale(mid,weights,days))
            {   
                ans = mid;
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
            }
        }

        return ans;
    }


    private boolean capabale(int cap, int[] weights, int days)
    {   
        int consumeDay = 0;
        int curLoad = 0;

        for(int w : weights)
        {
            if(curLoad == 0 || curLoad + w > cap)
            {
                consumeDay ++;
                curLoad = w;
            }
            else
            {
                curLoad += w;
            }

            // System.out.println("current consumde day is " + consumeDay);
            // System.out.println("current day " + consumeDay + " curLoad " + curLoad);
        }
        
        if(consumeDay > days)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}