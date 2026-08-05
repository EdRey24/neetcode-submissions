class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> numCharsofS = new HashMap<>();
        Map<Character,Integer> numCharsofT = new HashMap<>();
        for(char c : s.toCharArray()){
            numCharsofS.put(c, numCharsofS.getOrDefault(c, 0) + 1);
        }
        for(char c : t.toCharArray()){
            numCharsofT.put(c, numCharsofT.getOrDefault(c, 0) + 1);
        }
        return numCharsofS.equals(numCharsofT);
    }
}
