class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> stoneWeight = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones){
            stoneWeight.offer(stone);
        }
        while(stoneWeight.size() > 1){
            int x = stoneWeight.poll();
            int y = stoneWeight.poll();
            if(x != y){
                int remaining = Math.abs(x - y);
                stoneWeight.add(remaining);
            }
        }
        if(stoneWeight.isEmpty()){
            return 0;
        }else{
            return stoneWeight.poll();
        }
    }
}