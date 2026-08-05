class Solution {
    public int majorityElement(int[] nums) {
        int maxElement = 0;
        Map<Integer,Integer> counts = new HashMap<>();
        for(int num : nums){
            counts.put(num, counts.getOrDefault(num, 0) + 1);
            if(counts.getOrDefault(maxElement, 0) < counts.get(num)){
                maxElement = num;
            }
        }
        return maxElement;
    }
}