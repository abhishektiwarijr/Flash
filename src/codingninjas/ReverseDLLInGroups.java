package codingninjas;


public class ReverseDLLInGroups {
    public static void main(String[] args) {
        Node head = new Node(5);
        Node n2 = new Node(10);
        Node n3 = new Node(-6);
        Node n4 = new Node(4);
        Node n5 = new Node(7);
        Node last = new Node(-1);

        head.prev = last;
        head.next = n2;
        n2.prev = head;
        n2.next = n3;
        n3.next = n4;
        n3.prev = n2;
        n4.next = n5;
        n4.prev = n3;
        n5.next = last;
        n5.prev = n4;

        reverseDLLInGroups(head, 3);
    }
    public static Node reverseDLLInGroups(Node head, int k) {
        Node current = head;
        Node next = null;
        Node newHead = null;
        int count = 0;
        while (current != null && count < k) {
            next = current.next;
            newHead = push(newHead, current);
            current = next;
            count++;
        }
        if (next != null) {
            head.next = reverseDLLInGroups(next, k);
            head.next.prev = head;
        }
        return newHead;
    }
    private static Node push(Node head, Node newNode) {
        newNode.prev = null;
        newNode.next = head;
        if (head != null)
            head.prev = newNode;
        head = newNode;
        return head;
    }
}
class Node {
    public int data;
    public Node next;
    public Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}