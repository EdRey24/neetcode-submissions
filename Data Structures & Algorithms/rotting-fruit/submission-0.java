class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int fresh = 0;
        int time = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                if(grid[i][j] == 2){
                    q.offer(new int[] {i, j});
                }
            }
        }
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        while(fresh > 0 && !q.isEmpty()){
            int length = q.size();
            for(int i = 0; i < length; i++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                for(int[] dir : directions){
                    int row = r + dir[0];
                    int col = c + dir[1];
                    if(row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == 1){
                        grid[row][col] = 2;
                        fresh--;
                        q.offer(new int[] {row, col});
                    }
                }
            }
            time++;
        }
        if(fresh == 0){
            return time;
        }else{
            return -1;
        }
    }
}