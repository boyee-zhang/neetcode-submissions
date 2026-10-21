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

        for(int num : diff)
        {
            cur += num;

            if(cur > 1)
            {
                return false;
            }
        }

        return true;
    }
}
