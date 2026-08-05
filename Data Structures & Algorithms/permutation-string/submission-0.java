class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] chars = s1.toCharArray();
        Arrays.sort(chars);
        int left = 0;
        int right = s2.length() - chars.length;
        while(left <= right){
            String sub = s2.substring(left, left + chars.length);
            char[] ch = sub.toCharArray();
            Arrays.sort(ch);
            if(Arrays.equals(chars,ch)){
                return true;
            }
            left++;
        }
        return false;
    }
}
