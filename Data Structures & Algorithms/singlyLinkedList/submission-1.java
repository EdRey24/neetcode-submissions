class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public LinkedList() {
        head = null;
    }

    public int get(int index) {
        int i = 0;
        Node trav = head;
        while (trav != null && i < index) {
            trav = trav.next;
            i++;
        }
        if (trav == null) {
            return -1; // If index is out of bounds
        }
        return trav.val;
    }

    public void insertHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    public void insertTail(int val) {
        Node newNode = new Node(val);

        // If the list is empty, insert at the head
        if (head == null) {
            head = newNode;
            return;
        }

        // Traverse to the last node
        Node trav = head;
        while (trav.next != null) {
            trav = trav.next;
        }

        // Add the new node at the end
        trav.next = newNode;
    }

    public boolean remove(int index) {
        if (head == null) {
            return false; // List is empty, nothing to remove
        }

        Node trav = head;
        Node trail = null;
        int count = 0;

        // Traverse the list to find the node at the given index
        while (trav != null && count < index) {
            trail = trav;
            trav = trav.next;
            count++;
        }

        if (trav == null) {
            return false; // Index is out of bounds
        }

        if (trail == null) {
            // If we're removing the head node
            head = trav.next;
        } else {
            // Otherwise, bypass the node to remove it
            trail.next = trav.next;
        }

        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>();
        Node trav = head;
        while (trav != null) {
            values.add(trav.val);
            trav = trav.next; // Move to the next node
        }
        return values;
    }
}