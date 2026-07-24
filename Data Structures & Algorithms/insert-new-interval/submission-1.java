/**
 * Algorithm
 *
 * 1. Initialize an empty result list {@code res} and index {@code i = 0}.
 * 2. Add all intervals that end before {@code newInterval} starts:
 *      - while intervals[i].end < newInterval.start, append intervals[i] to res
 * 3. Merge all intervals that overlap with {@code newInterval}:
 *      - while intervals[i].start <= newInterval.end, update:
 *          - newInterval.start = min(newInterval.start, intervals[i].start)
 *          - newInterval.end   = max(newInterval.end, intervals[i].end)
 * 4. Append the merged {@code newInterval} to {@code res}.
 * 5. Append all remaining intervals (which must come after) to {@code res}.
 * 6. Return {@code res}.
 */

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int i = 0;
        List<int[]> res = new ArrayList<>();

        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        res.add(newInterval);

        while (i < n) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);
    }
}
