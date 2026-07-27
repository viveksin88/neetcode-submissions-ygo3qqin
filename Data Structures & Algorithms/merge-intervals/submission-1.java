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
        List<int[]> output = new ArrayList<>();

        output.add(intervals[0]);

        for (int[] interval: intervals) {
            int start = interval[0];
            int end = interval[1];
            int lastIndex = output.size() - 1;
            int lastEnd = output.get(lastIndex)[1];

            if (start <= lastEnd) {
                output.get(lastIndex)[1] = Math.max(interval[1], lastEnd);
            } else {
                output.add(new int[]{start, end});
            }
        }

        return output.toArray(new int[output.size()][]);
    }
}
