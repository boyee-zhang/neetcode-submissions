class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        //sort intervals base on the interval start index
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();

        int count = 0;

        for(int[] interval : intervals)
        {
           if(res.isEmpty())
           {
                res.add(interval);
           }
           else
           {
                int[] prev = res.get(res.size() - 1);

                if(prev[1] > interval[0]) {   
                    if (interval[1] < prev[1]) {
                        res.remove(res.size() - 1);
                        res.add(interval);
                    }
                } else {
                    res.add(interval);
                }
           }
        }

        return intervals.length - res.size();

    }
}
