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
        Collections.sort(intervals,(a,b) -> a.start - b.start);

        List<Interval> res = new ArrayList<>();
        for(Interval interval : intervals)
        {
            if(res.isEmpty())
            {
                res.add(interval);
            }
            else
            {
                Interval prev = res.get(res.size() - 1);

                if(prev.end > interval.start)
                {
                    return false;
                }
                else
                {
                    res.add(interval);
                }
            }
        }

        return true;
    }
}
