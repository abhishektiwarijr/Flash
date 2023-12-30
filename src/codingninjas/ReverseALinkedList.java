package codingninjas;

public class ReverseALinkedList {

    public static void main(String[] args) {
        LLNode head = new LLNode(1, new LLNode(2, new LLNode(3, null)));

        //Print before reversing
        printLinkedList(head);

        //Reverse the LinkedList
        LLNode reversedHead = reverseRec(head);

        //Print after reversing
        printLinkedList(reversedHead);
    }

    private static LLNode reverseLinkedList(LLNode head) {
        LLNode prev = null;
        LLNode curr = head;

        while (curr != null) {
            LLNode next = curr.next; //Put current's next in next
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

    /**
     * The idea is to reach the last node of the linked list using recursion
     * then start reversing the linked list.
     * @param head {head of the list}
     * @return LLNode
     */
    private static LLNode reverseRec(LLNode head) {
        if(head == null || head.next == null) return head;

        LLNode h2 = reverseRec(head.next);
        head.next.next = head;
        head.next = null;

        return h2;
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
