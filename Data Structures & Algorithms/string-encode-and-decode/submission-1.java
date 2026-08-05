class Solution {

    public String encode(List<String> strs) {
        String encoded = "";
        for (String str : strs) {
            encoded += str + "~";
        }
        return encoded;
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int left = 0;
        int right = 0;
        while(right < str.length()){
            if(str.charAt(right) == '~'){
                String word = str.substring(left,right);
                decoded.add(word);
                left = right + 1;
                right = left;
            }
            right++;
        }
        return decoded;
    }
}
