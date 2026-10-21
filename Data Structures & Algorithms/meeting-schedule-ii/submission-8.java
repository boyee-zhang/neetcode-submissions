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
        if(intervals.size() == 0)
        {
            return 0;
        }
        Collections.sort(intervals,(a,b) -> a.start - b.start);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
        for(Interval interval : intervals)
        {
            if(!minHeap.isEmpty() && interval.start >= minHeap.peek())
            {
                minHeap.poll();
            }

            minHeap.add(interval.end);
        }

        return minHeap.size();
    }
}
