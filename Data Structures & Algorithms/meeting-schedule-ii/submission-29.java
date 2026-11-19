class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

        if (intervals == null || intervals.size() == 0) {
            return 0;
        }

        Collections.sort(intervals, (a, b) -> a.start - b.start);

        PriorityQueue<Interval> minHeap =
            new PriorityQueue<>((a, b) -> a.end - b.end);

        for (Interval i : intervals) {
            if (minHeap.isEmpty()) {
                minHeap.add(i);
            } else {
                if (!minHeap.isEmpty() && minHeap.peek().end <= i.start) {
                     minHeap.poll();
                }    
                minHeap.add(i);
            }
        }

        return minHeap.size();
    }
}