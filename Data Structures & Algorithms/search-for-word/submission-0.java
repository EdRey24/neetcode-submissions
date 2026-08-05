class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(dfs(board, word, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int idx, int row, int col){
        if(idx == word.length()){
            return true;
        }
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(idx) || board[row][col] == '#'){
            return false;
        }
        board[row][col] = '#';
        boolean result = dfs(board, word, idx + 1, row + 1, col) || 
                         dfs(board, word, idx + 1, row - 1, col) || 
                         dfs(board, word, idx + 1, row, col + 1) || 
                         dfs(board, word, idx + 1, row, col - 1);
        board[row][col] = word.charAt(idx);
        return result;
    }
}