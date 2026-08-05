class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> dups = new HashSet<>();
        for(int i : nums){
            if(dups.contains(i)){
                return true;
            }
            dups.add(i);
        }
        return false;
    }
}