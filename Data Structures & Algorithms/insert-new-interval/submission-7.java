class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        
        List<int[]> res = new LinkedList<>();
        //three phrase 

        int start = newInterval[0];
        int end = newInterval[1];

        int i = 0;
        int n = intervals.length;

        while(i < n && intervals[i][1] < start)
        {
            res.add(intervals[i]);
            i ++;
        }

        while(i < n && intervals[i][0] <= end)
        {
            start = Math.min(start,intervals[i][0]);
            end = Math.max(end,intervals[i][1]);

            i ++;
        }

        res.add(new int[] {start, end});

        while(i < n)
        {
            res.add(intervals[i]);
            i ++;
        }

        int[][] ans = new int [res.size()][2];

        for(int j = 0; j < ans.length; j ++)
        {
            ans[j][0] = res.get(j)[0];
            ans[j][1] = res.get(j)[1];
        }

        return ans;
    }
}
