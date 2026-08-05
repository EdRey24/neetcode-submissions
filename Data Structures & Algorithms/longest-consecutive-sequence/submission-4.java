class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        Set<Integer> sequence = new TreeSet<>();
        for(int num : nums){
            sequence.add(num);
        }
        int[] sorted_nums = new int[sequence.size()];
        int i = 0;
        for(int num : sequence){
            sorted_nums[i] = num;
            i++;
        }
        int longest_sequence = 1;
        int current_sequence = 1;
        int left = 0;
        int right = 1;
        while(right < sorted_nums.length){
            if(sorted_nums[right] - sorted_nums[left] == 1){
                current_sequence++;
                if(current_sequence > longest_sequence){
                    longest_sequence = current_sequence;
                }
            }else{
                current_sequence = 1;
            }
            left++;
            right++;
        }
        return longest_sequence;
    }
}
