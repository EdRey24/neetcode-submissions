class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;

    public TrieNode(){
        children = new HashMap<>();
        isWord = false;
    }

    public void addWord(String word){
        TrieNode curr = this;
        for(char ch : word.toCharArray()){
            curr.children.putIfAbsent(ch, new TrieNode());
            curr = curr.children.get(ch);
        }
        curr.isWord = true;
    }
}

class Solution {
    private Set<String> result;
    
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words){
            root.addWord(word);
        }
        int rows = board.length;
        int cols = board[0].length;
        result = new HashSet<>();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                dfs(board, i, j, root, "");
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, int row, int col, TrieNode node, String word){
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == '#' || !node.children.containsKey(board[row][col])){
            return;
        }
        char c = board[row][col];
        node = node.children.get(board[row][col]);
        word += board[row][col];
        board[row][col] = '#';
        if(node.isWord){
            result.add(word);
        }
        dfs(board, row + 1, col, node, word);
        dfs(board, row - 1, col, node, word);
        dfs(board, row, col + 1, node, word);
        dfs(board, row, col - 1, node, word);
        board[row][col] = c;
    }
}
