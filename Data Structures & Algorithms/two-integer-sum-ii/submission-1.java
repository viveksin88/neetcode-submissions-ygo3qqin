class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int l = i + 1, r = numbers.length - 1;
            int tmp = target - numbers[i];

            while (l <= r) {
                int m = l + ((r - l) / 2);
                if (numbers[m] == tmp) {
                    return new int[] {i + 1, m + 1};
                } else if (numbers[m] < tmp) {
                    l = m + 1;
                } else if (numbers[m] > tmp) {
                    r = m - 1;
                }
            }
        }
        return new int[0];
    }
}
