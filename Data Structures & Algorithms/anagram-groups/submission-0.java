class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if(groups.containsKey(sorted)){
                List<String> vals = groups.get(sorted);
                vals.add(str);
                groups.put(sorted, vals);
            }else{
                List<String> vals = new ArrayList<>();
                vals.add(str);
                groups.put(sorted, vals);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(List<String> group : groups.values()){
            result.add(group);
        }
        return result;
    }
}
