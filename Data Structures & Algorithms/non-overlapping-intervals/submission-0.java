class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        //sort intervals base on the interval start index
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();

        for(int[] interval : intervals)
        {
            if(res.isEmpty())
            {
                res.add(interval);
            }
            else
            {
                int[] prev = new int [2];
                prev[0] = res.get(res.size() - 1)[0];
                prev[1] = res.get(res.size() - 1)[1];

                if(interval[0] >= prev[1])
                {
                    res.add(interval);
                }
                else if (interval[1] <= prev[0])
                {
                    res.add(interval);
                }
                else
                {
                    interval[0] = Math.max(interval[0],prev[0]);
                    interval[1] = Math.min(interval[1],prev[1]);
                    res.remove(res.size() - 1);
                    res.add(interval);
                }
            }
        }

        return intervals.length - res.size();

    }
}
