class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        int left = 0;
        int result = 0;
        int mostLetters = 0;
        for(int right = 0; right < s.length(); right++){
            count.put(s.charAt(right), count.getOrDefault(s.charAt(right), 0) + 1);
            mostLetters = Math.max(mostLetters, count.get(s.charAt(right)));
            while(right - left + 1 - mostLetters > k){
                count.put(s.charAt(left), count.get(s.charAt(left)) - 1);
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
