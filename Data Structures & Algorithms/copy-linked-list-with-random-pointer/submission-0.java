/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        Node prev = null;
        Node copyHead = null;
        while(curr != null){
            Node newNode = new Node(curr.val);
            map.put(curr, newNode);
            if(curr == head){
                copyHead = newNode;
            }else{
                prev.next = newNode;
            }
            prev = newNode;
            curr = curr.next;
        }
        curr = head;
        Node copyCurr = copyHead;
        while(curr != null){
            if(curr.random == null){
                copyCurr.random = null;
            }else{
                Node rand = map.get(curr.random);
                copyCurr.random = rand;
            }
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return copyHead;
    }
}