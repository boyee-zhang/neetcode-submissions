class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        
        int m = queries.length;
        int n = intervals.length;

        int[][] sortedQueries = new int[m][2];

        for(int i = 0; i < m; i ++)
        {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        int[] res = new int[m];
        Arrays.sort(sortedQueries,(a,b) -> a[0] - b[0]);

        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        int i = 0;

        for(int[] q : sortedQueries)
        {
            int queryIndex = q[1];
            int queryVal = q[0];

            // System.out.printf("current location %d , index %d \n",queryVal,queryIndex);
            while(i < n && intervals[i][0] <= queryVal)
            {   
                int left = intervals[i][0];
                int right = intervals[i][1];

                pq.add(new int[] {right,right - left + 1});
                i ++;
            }

            while(!pq.isEmpty() && pq.peek()[0] < queryVal)
            {
                pq.poll();
            }

            if(pq.isEmpty())
            {
                res[queryIndex] = -1;
            }
            else
            {
                res[queryIndex] = pq.peek()[1];
            }
        }

        return res;
    }
}
