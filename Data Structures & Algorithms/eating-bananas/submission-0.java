class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int left = 1;
        int right = piles[piles.length - 1];
        int ans = right;

        while(left <= right){
            int mid = (left + right) / 2;
            if(canFinish(piles, h, mid)){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }

    public boolean canFinish(int[] piles, int h, int k){
        int hours = 0;
        for(int pile : piles){
            hours += Math.ceil(1.0 * pile / k);
        }
        return hours <= h;
    }
}