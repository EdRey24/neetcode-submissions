class Solution {
    public String longestCommonPrefix(String[] strs) {
        String longestPrefix = "";
        int idx = 0;
        int smallestWord = Integer.MAX_VALUE;
        boolean mismatch = false;
        for(int i = 0; i < strs.length; i++){
            if (strs[i].length() < smallestWord){
                smallestWord = strs[i].length();
            }
        }
        while(idx < smallestWord && !mismatch){
            char ch = strs[0].charAt(idx);
            for(int i = 1; i < strs.length; i++){
                if(ch != strs[i].charAt(idx)){
                    mismatch = true;
                    break;
                }
            }
            if(!mismatch){
                longestPrefix += ch;
                idx++;
            }
        }
        return longestPrefix;
        
    }
}