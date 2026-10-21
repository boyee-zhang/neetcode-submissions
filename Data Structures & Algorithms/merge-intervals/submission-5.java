class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);

        int i = 0;
        int n = intervals.length;

        List<int[]> res = new LinkedList<>();

        
        while(i < n)
        {   
            int start = intervals[i][0];
            int end = intervals[i][1];

            int j = i + 1;
            boolean needMerge = false;

            while(j < n && intervals[j][0] <= end)
            {
                start = Math.min(start,intervals[j][0]);
                end = Math.max(end,intervals[j][1]);
                needMerge = true;
                j ++;
            }

            if(needMerge)
            {
                res.add(new int[] {start, end});
            }
            else
            {   
                start = intervals[i][0];
                end = intervals[i][1];
                res.add(intervals[i]);
            }
            
            i = j;
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
