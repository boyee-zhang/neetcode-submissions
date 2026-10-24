class Solution {

    /*
        require:
            - if at any time point, the curr load is less than cap return true
            - otherwise return false
        
        invariant:
            - at any time point i, current load = previous load number + new coming load number 
            
    */
    public boolean carPooling(int[][] trips, int capacity) {
        int curLoad = 0; 

        Arrays.sort(trips,(a,b) -> a[1] - b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);

        for(int[] trip : trips)
        {
            curLoad += trip[0];
            int curTime = trip[1];
            
            
            while(!pq.isEmpty() && pq.peek()[2] <= trip[1])
            {
                System.out.println("before " + curLoad);

                curLoad -= pq.peek()[0];
                pq.poll();

                System.out.println("after " + curLoad);
                System.out.println("1");
            }

            if(curLoad > capacity)
            {
                System.out.println("current trip left " + trip[1] + " right " + trip[2]);
                System.out.println("current load " + curLoad);
                return false;
            }

            pq.add(trip);

        }

        return true;
    }
}