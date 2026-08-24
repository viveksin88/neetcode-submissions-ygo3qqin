/**
 * Algorithm
 *
 * 1. Sort all intervals by their start time.
 * 2. Initialize the result list {@code output} with the first interval.
 * 3. Iterate through each interval (start, end) in the sorted list:
 * 4. Let {@code lastEnd} be the end of the last interval in {@code output}.
 * 5. If the current interval overlaps with the last one (start <= lastEnd):
 *      - Merge them by updating the end:
 *          - output[-1][1] = max(lastEnd, end)
 * 6. Otherwise (no overlap):
 *      - Append the current interval to output as a new interval
 * 7. After processing all intervals, return output.
 */

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();

        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            int lastIndex = res.size() - 1;
            int lastEnd = res.get(lastIndex)[1];

            if (start <= lastEnd) {
                res.get(lastIndex)[1] = Math.max(intervals[i][1], lastEnd);
            } else {
                res.add(new int[]{start, end});
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
