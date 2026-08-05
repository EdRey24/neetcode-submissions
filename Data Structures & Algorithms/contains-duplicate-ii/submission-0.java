class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> found = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(found.containsKey(nums[i])){
                if(Math.abs(found.get(nums[i]) - i) <= k){
                    return true;
                }
            }
            found.put(nums[i],i);
        }
        return false;
    }
}