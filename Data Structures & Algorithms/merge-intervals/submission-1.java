class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[] > res = new ArrayList<>();

        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);



        for(int[] interval : intervals)
        {
            if(res.isEmpty())
            {
                res.add(interval);
            }
            else
            {
                int[] prevInterval = new int[2];

                prevInterval[0] = res.get(res.size() - 1)[0];
                prevInterval[1] = res.get(res.size() - 1)[1];
                
                if(prevInterval[1] < interval[0])
                {
                    res.add(interval);
                }
                else if(prevInterval[0] > interval[1])
                {
                    res.add(interval);
                }
                else
                {
                    interval[0] = Math.min(interval[0], prevInterval[0]);
                    interval[1] = Math.max(interval[1], prevInterval[1]);
                    res.remove(res.size() - 1);
                    res.add(interval);
                }
            }
        }

        return res.toArray(new int[0][]);
    }
}
