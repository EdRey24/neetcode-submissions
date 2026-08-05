class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> closest = new PriorityQueue<double[]>(
            (a, b) -> Double.compare(b[0], a[0]) // Assuming you want to sort by the first element in descending order
        );
        for(int[] point : points){
            double[] group = new double[3];
            group[0] = Math.sqrt(Math.pow(point[0],2) + Math.pow(point[1],2));
            group[1] = point[0];
            group[2] = point[1];
            closest.add(group);
            if(closest.size() > k){
                closest.poll();
            }
        }
        int[][] result = new int[closest.size()][2];
        int SIZE = closest.size();
        for(int i = 0; i < SIZE; i++){
            double[] point = closest.poll();
            result[i][0] = (int) point[1];
            result[i][1] = (int) point[2];
        }
        return result;
    }
}
