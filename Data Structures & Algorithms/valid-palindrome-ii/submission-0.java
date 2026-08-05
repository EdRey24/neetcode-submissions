class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        boolean deleted = false;
        return search(s, left, right, deleted);
    }

    private boolean search(String s, int left, int right, boolean deleted){
        while(left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else if(deleted){
                return false;
            }else{
                return search(s, left + 1, right, true) || search(s, left, right - 1, true);
            }
        }
        return true;
    }
}