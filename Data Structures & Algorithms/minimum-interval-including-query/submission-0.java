class Solution {

    //brute force  O(N^2)
    public int[] minInterval(int[][] intervals, int[] queries) {
        
        int n = queries.length;
        int index = 0;
        int[] res = new int [n];

        for(int query : queries)
        {
            int min = Integer.MAX_VALUE;

            for(int[] interval : intervals)
            {
                int start = interval[0];
                int end = interval[1];

                if(start <= query && query <= end)
                {
                    min = Math.min(min,end - start + 1);
                }
            }

            if(min == Integer.MAX_VALUE)
            {
                res[index ++] = -1;
            }
            else
            {
                res[index ++] = min;
            }
        }

        return res;
    }
}
