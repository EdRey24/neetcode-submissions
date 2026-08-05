class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, path, result);
        return result;
    }

    private void backtrack(int[] nums, int i, List<Integer> path, List<List<Integer>> result){
        result.add(new ArrayList<>(path));
        for(int j = i; j < nums.length; j++){
            if(j > i && nums[j] == nums[j-1]){
                continue;
            }
            path.add(nums[j]);
            backtrack(nums, j+1, path, result);
            path.remove(path.size() - 1);
        }
    }
}   
