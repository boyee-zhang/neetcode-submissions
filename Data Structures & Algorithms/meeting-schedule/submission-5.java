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
        
        int mostRight = 0;

        for(Interval i : intervals)
        {   
            int right = i.end;
            mostRight = Math.max(mostRight, right);
        }

        int[] diff = new int [mostRight + 1];

        for(Interval i : intervals)
        {
            int start = i.start;
            int end = i.end;

            diff[start] ++;
            diff[end] --;
        }

        int cur = diff[0];

        for(int i = 1; i < mostRight; i ++)
        {
            cur +=  diff[i];

            if(cur > 1)
            {   
                System.out.println("check current i " + i);
                return false;
            }
        }

        return true;
    }
}
