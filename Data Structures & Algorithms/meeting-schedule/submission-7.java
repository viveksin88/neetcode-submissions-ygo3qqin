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

 /**

Algorithm:

1. Sort all meetings by their start time.
2. Iterate through the sorted list starting from the second meeting:
3. For each pair of adjacent meetings:
   -let i1 be the previous meeting
   -let i2 be the current meeting
4. If i1.end > i2.start:
   - the meetings overlap
   - return false
5. If the loop finishes without finding any overlap:
   -return true
 **/

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
