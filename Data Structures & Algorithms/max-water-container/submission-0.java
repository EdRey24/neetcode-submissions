class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            int lheight = height[left];
            int rheight = height[right];
            int area = (right - left) * Math.min(lheight, rheight);
            if(area > maxArea){
                maxArea = area;
            }
            if(lheight <= rheight){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}