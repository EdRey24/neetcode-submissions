class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> largest = new PriorityQueue<>();
        for(int n : nums){
            largest.add(n);
            if(largest.size() > k){
                largest.remove();
            }
        }
        return largest.poll();
    }
}
