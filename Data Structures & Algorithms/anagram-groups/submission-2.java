class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> wordMap = new HashMap<>();

        for (String str: strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String newString = new String(charArray);

            wordMap.computeIfAbsent(newString, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(wordMap.values());
    }
}
