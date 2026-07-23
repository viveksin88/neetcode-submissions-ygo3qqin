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
        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));
        
        int latestEnd = 0;
        for (Interval interval: intervals) {
            if (interval.start < latestEnd) {
                return false;
            }

            latestEnd = Math.max(interval.end, latestEnd);
        }

        return true;
    }
}
