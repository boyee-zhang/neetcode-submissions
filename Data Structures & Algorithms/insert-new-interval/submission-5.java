class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]>  res = new ArrayList<>();
        boolean flag = true;

        // if(intervals.length == 0)
        // {
        //     res.add(newInterval);
        // }
        for(int[] interval : intervals)
        {
            if(interval[1] < newInterval[0])
            {
                res.add(interval);
            }
            else if(interval[0] > newInterval[1])
            {   
                if(flag)
                res.add(newInterval);
                res.add(interval);
                flag = false;
            }
            else
            {
                newInterval[0] = Math.min(newInterval[0] , interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
                flag = true;
                // res.add(newInterval);
            }
        }

        if(flag)
        {
            res.add(newInterval);
        }
         
        return res.toArray(new int[0][]);
    }
}
