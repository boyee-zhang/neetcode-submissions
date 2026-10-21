class Solution {

    //brute force  O(N^2)
    public int[] minInterval(int[][] intervals, int[] queries) {
        
        int m = intervals.length;
        int n = queries.length;
    
        int[] res = new int [n];

        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);

        int[][] sortedQueries = new int[n][2];
        for (int i = 0; i < n; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i; 
        }

        Arrays.sort(sortedQueries, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int j = 0;

        for(int i = 0; i < queries.length; i ++)
        {
            int index = sortedQueries[i][1];
            int val = sortedQueries[i][0];

            while(j < m && intervals[j][0] <= val)
            {   
                int start = intervals[j][0];
                int end = intervals[j][1];
                int len = end - start + 1;

                pq.add(new int[]{len,end});
                j ++;
            }

            while(!pq.isEmpty() && pq.peek()[1] < val)
            {
                pq.poll();
            }

            if(pq.isEmpty())
            {
                res[index] = -1;
            }
            else
            {
                res[index] = pq.peek()[0];
            }
        }



        return res;
    }

    public int BinarySearch(int[][] intervals,int target)
    {   
        int left = 0;
        int right = intervals.length - 1;
        int ans = -1;

        while(left <= right)
        {
            int mid = left + (right - left) / 2;

            if(intervals[mid][0] <= target)
            {
                ans = mid;
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }

        return ans;
    }

}
