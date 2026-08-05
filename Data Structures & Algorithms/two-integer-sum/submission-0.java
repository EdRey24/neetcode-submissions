class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] pair = new int[2];
        Map<Integer, List<Integer>> idx = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            idx.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        for(int i : idx.keySet()){
            int j = target - i;
            if(idx.containsKey(j)){
                if(i == j && idx.get(i).size() > 1){
                    pair[0] = idx.get(i).get(0);
                    pair[1] = idx.get(i).get(1);
                }else{
                    pair[0] = idx.get(i).get(0);
                    pair[1] = idx.get(j).get(0);
                }
                Arrays.sort(pair);
                return pair;
            }
        }
        return pair;
    }
}
