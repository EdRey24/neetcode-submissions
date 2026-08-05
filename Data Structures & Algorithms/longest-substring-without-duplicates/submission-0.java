class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> letters = new HashSet<>();
        int left = 0;
        int result = 0;
        for(int right = 0; right < s.length(); right++){
            while(letters.contains(s.charAt(right))){
                letters.remove(s.charAt(left));
                left++;
            }
            letters.add(s.charAt(right));
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
