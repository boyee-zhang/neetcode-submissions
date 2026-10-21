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

        System.out.println(leastWeight);

        for(int i = leastWeight; i <= maxWeight; i ++)
        {
            if(capabale(i,weights,days))
            {
                return i;
            }
        }

        return -1;
    }


    private boolean capabale(int cap, int[] weights, int days)
    {   
        int consumeDay = 1;
        int curLoad = 0;

        for(int w : weights)
        {
            if(curLoad + w <= cap)
            {
                curLoad += w;
            }
            else
            {
                curLoad = w;
                consumeDay ++;
            }
        }
        
        System.out.println("consumeDay " + consumeDay + " curLoad " + curLoad);
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