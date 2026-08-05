class TrieNode{
    Map<Character, TrieNode> children = new HashMap<>();
    boolean endOfWord = false;
}

class WordDictionary {
    public TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public WordDictionary(TrieNode curr) {
        root = curr;
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for(char letter : word.toCharArray()){
            curr.children.putIfAbsent(letter, new TrieNode());
            curr = curr.children.get(letter);
        }
        curr.endOfWord = true;
    }
    
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int j, TrieNode root) {
        TrieNode cur = root;

        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode child : cur.children.values()) {
                    if (dfs(word, i + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (!cur.children.containsKey(c)) {
                    return false;
                }
                cur = cur.children.get(c);
            }
        }
        return cur.endOfWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */