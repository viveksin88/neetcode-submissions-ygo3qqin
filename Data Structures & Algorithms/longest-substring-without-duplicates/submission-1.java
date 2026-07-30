/*
Variable size window problem:
Pattern:
int left = 0;

for (int right = 0; right < nums.length; right++) {
    // Add nums[right]

    while (windowIsInvalid()) {
        // Remove nums[left]
        left++;
    }

    // Update answer using right - left + 1
}

*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int output = 0;

        Set<Character> charSet = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            while(charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }
            output = Math.max(output, right - left + 1);
            charSet.add(s.charAt(right));
        }
        return output;
    }
}
