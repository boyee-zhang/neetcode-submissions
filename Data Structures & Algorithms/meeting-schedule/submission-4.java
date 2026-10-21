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
        
        if(intervals.size() == 0 || intervals == null)
        {
            return true;
        }
        Collections.sort(intervals,(a,b) -> a.end - b.end);
        int n = intervals.get(intervals.size() - 1).end;

        int[] diff = new int [n + 1];

        for(Interval interval : intervals)
        {
            int start = interval.start;
            int end = interval.end;

            diff[start] += 1;
            diff[end] -= 1;
        }

        int[] prefix = new int [n + 1];
        
        prefix[0] = diff[0];
        for(int i = 1; i < n ; i ++)
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
