class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        final Map<String, List<String>> wordMap = new HashMap<>();
        
        for (String s: strs) {
            char[] originalArray = s.toCharArray();
            Arrays.sort(originalArray);
            String newStr = new String(originalArray);

            wordMap.computeIfAbsent(newStr, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(wordMap.values());
    }
}
