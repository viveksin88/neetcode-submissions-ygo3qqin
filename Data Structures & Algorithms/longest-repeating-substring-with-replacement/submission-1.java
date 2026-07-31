/*

for (int right = 0; right < nums.length; right++) {
    // Add nums[right]

    if (right >= k) {
        // Remove nums[right - k]
    }

    if (right >= k - 1) {
        // Process current window
    }
}

*/

class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        HashSet<Character> charSet = new HashSet<>();

        for (Character c: s.toCharArray()) {
            charSet.add(c);
        }

        for (Character c: charSet) {
            int count = 0, l = 0;

            for (int r = 0; r < s.length(); r++) {
                if (s.charAt(r) == c) {
                    count++;
                }

                while ((r - l + 1) - count > k) {
                    if (s.charAt(l) == c) {
                        count--;
                    }
                    l++;
                }

                res = Math.max(res, r - l + 1);
            }
        }
        return res;
    }
}
