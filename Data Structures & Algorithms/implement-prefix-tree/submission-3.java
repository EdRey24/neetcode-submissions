class PrefixTree {
    Node root;

    public PrefixTree() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for(char ch : word.toCharArray()){
            curr.children.putIfAbsent(ch, new Node());
            curr = curr.children.get(ch);
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        Node curr = root;
        for(char ch : word.toCharArray()){
            if(!curr.children.containsKey(ch)){
                return false;
            }else{
                curr = curr.children.get(ch);
            }
        }
        return curr.endOfWord;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for(char ch : prefix.toCharArray()){
            if(!curr.children.containsKey(ch)){
                return false;
            }else{
                curr = curr.children.get(ch);
            }
        }
        return true;
    }
}

class Node {
    public Map<Character, Node> children;
    public boolean endOfWord;

    public Node(){
        this.children = new HashMap<>();
        this.endOfWord = false;
    }
}
