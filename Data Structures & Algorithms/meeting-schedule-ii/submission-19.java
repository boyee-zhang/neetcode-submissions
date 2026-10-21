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
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0)
        {
            return 0;
        }
        PriorityQueue<Interval> queue = new PriorityQueue<>((a,b) -> a.end - b.end);

        intervals.sort((a,b) -> a.start - b.start);
        int max = 0;

        for(Interval interval : intervals)
        {
            while(!queue.isEmpty() && queue.peek().end <= interval.start)
            {
                queue.poll();
            }
            queue.add(interval);
            max = Math.max(max,queue.size());
        }

        return max;
    }
}
