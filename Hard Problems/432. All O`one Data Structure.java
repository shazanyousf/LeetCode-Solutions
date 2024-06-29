import java.util.HashMap;
import java.util.Map;

class AllOne {
    static class Node {
        String string;
        int count;
        Node prev;
        Node next;

        Node() {
            this.string = "";
        }
        Node(String string, int count) {
            this.string = string;
            this.count = count;
        }
    }
    Map<String, Node> stringNodeMap;
    Node head;
    Node tail;

    public AllOne() {
        this.stringNodeMap = new HashMap<>();
        this.head = new Node();
        this.tail = new Node();

        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    private Node insertKeyAtBeginning(String key) {
        Node node = new Node(key, 1);

        this.head.next.prev = node;
        node.next = this.head.next;
        this.head.next = node;
        node.prev = this.head;

        return node;
    }
    public void inc(String key) {
        if (stringNodeMap.containsKey(key)) {
            
            Node node = stringNodeMap.get(key);
            node.count++;

            while (node.next != this.tail && node.count > node.next.count) {
                Node prev = node.prev;
                Node next = node.next;

                prev.next = next;
                next.prev = prev;

                node.next = next.next;
                next.next.prev = node;

                next.next = node;
                node.prev = next;
            }
        } else {
            Node node = insertKeyAtBeginning(key);
            this.stringNodeMap.put(key, node);
        }
    }
    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;

        node.next = null;
        node.prev = null;
    }
    public void dec(String key) {
        Node node = stringNodeMap.get(key);
        if (node.count == 1) {
         
            removeNode(node);
            this.stringNodeMap.remove(key);
        } else {
            
            node.count--;

            while (node.prev != this.head && node.count < node.prev.count) {
                Node prev = node.prev;
                Node next = node.next;

                prev.next = next;
                next.prev = prev;

                node.prev = prev.prev;
                prev.prev.next = node;

                prev.prev = node;
                node.next = prev;
            }
        }
    }
    public String getMaxKey() {
        return this.tail.prev.string;
    }
    public String getMinKey() {
        return this.head.next.string;
    }
}