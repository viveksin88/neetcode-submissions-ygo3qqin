class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numCount = new HashMap<>();

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
        );

        for (Integer n: nums) {
            numCount.merge(n, 1, Integer::sum);
        }

        maxHeap.addAll(numCount.entrySet());

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll().getKey();
        }

        return result;
    }
}
