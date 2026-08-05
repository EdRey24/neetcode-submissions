class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> prev = new HashMap<>();
        for(int i = 0; i < numbers.length; i++){
            int diff = target - numbers[i];
            if(prev.containsKey(diff)){
                return new int[] {prev.get(diff)+1, i+1};
            }else{
                prev.put(numbers[i], i);
            }
        }
        return new int[]{};
    }
}
