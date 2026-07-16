class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        final Map<String, List<String>> wordMap = new HashMap<>();
        
        for (String s: strs) {
            char[] originalArray = s.toCharArray();
            Arrays.sort(originalArray);
            String newStr = new String(originalArray);

            if (wordMap.containsKey(newStr)) {
                List<String> wordList = wordMap.get(newStr);
                wordList.add(s);
                wordMap.put(newStr, wordList);
            } else {
                wordMap.put(newStr, new ArrayList<>(Arrays.asList(s)));
            }
        }

        return new ArrayList<>(wordMap.values());
    }
}
