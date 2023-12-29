package codingninjas;

public class ReverseALinkedList {

    public static void main(String[] args) {
        LLNode head = new LLNode(1, new LLNode(2, new LLNode(3, null)));

        //Print before reversing
        printLinkedList(head);

        //Reverse the LinkedList
        LLNode reversedHead = reverseLinkedList(head);

        //Print after reversing
        printLinkedList(reversedHead);
    }

    private static LLNode reverseLinkedList(LLNode head) {
        LLNode prev = null;
        LLNode curr = head;
        LLNode next;

        while (curr != null) {
            next = curr.next; //Put current's next in next
            curr.next = prev; //Make current's next to previous
            prev = curr; //Shift previous to current
            curr = next; //And shift current to next
        }

        return prev;
    }

    private static void printLinkedList(LLNode head) {
        LLNode start = head;
        while (start != null) {
            System.out.print(start.data + " -> ");
            start = start.next;
        }
        System.out.println();
    }
}

class LLNode {
    public int data;
    public LLNode next;

    LLNode(int data, LLNode next) {
        this.data = data;
        this.next = next;
    }
}
