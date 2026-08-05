class TrieNode{
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean endOfWord = false;
}

class PrefixTree {

    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(char letter : word.toCharArray()){
            curr.children.putIfAbsent(letter, new TrieNode());
            curr = curr.children.get(letter);
        }
        curr.endOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(char letter : word.toCharArray()){
            if(!curr.children.containsKey(letter)){
                return false;
            }
            curr = curr.children.get(letter);
        }
        return curr.endOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char letter : prefix.toCharArray()){
            if(!curr.children.containsKey(letter)){
                return false;
            }
            curr = curr.children.get(letter);
        }
        return true;
    }
}
