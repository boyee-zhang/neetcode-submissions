/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {

        Collections.sort(intervals,(a,b) -> a.end - b.end);

        if(intervals.size() == 0 || intervals == null)
        {
            return true;
        }
        int n = intervals.get(intervals.size() - 1).end;

        int[] diff = new int [n + 1];

        for(Interval i : intervals)
        {   
            int start = i.start;
            int end = i.end;

            diff[start] ++;
            diff[end] --;
        }

        int cur = 0;

        int[] prefix = new int [n];
        
        prefix[0] = diff[0];
        //prefix[i] = diff[i] + nums[i - 1] = diff[i] + sumOf(diff[i - 1], diff[0]);

        for(int i = 1; i < n; i ++)
        {
            prefix[i] = prefix[i - 1] + diff[i];

            if(prefix[i] > 1)
            {
                return false;
            }
        }

        return true;
    }
}
