package dsalg;

/**
 *
 * @author nmorla
 * @since Aug 22, 2020
 */
public class SingleLinkedListLeverse {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        for (int i = 0; i < 10; i++) {
            list.insertNode(i * 3);
        }
        list.printElements(list.head);
        if (list.head == null) {
            System.out.println("List is empty.");
        } else {
            SinglyLinkedListNode e1 = list.head;
            SinglyLinkedListNode e2 = e1.next;
            SinglyLinkedListNode revHead = reverse(e1, e2);
            list.printElements(revHead);
        }
    }

    static SinglyLinkedListNode reverse(SinglyLinkedListNode e1, SinglyLinkedListNode e2) {
        if (e1 == null) {
            return null;
        } else if (e2 == null) {
            return e1;
        } else {
            SinglyLinkedListNode nextNodeInList = e2.next;
            e2.next = e1;
            if (e1.next == e2) {
                e1.next = null;
            }
            System.out.println(e1 + " <--> " + e2 + " <--> " + nextNodeInList);
            return reverse(e2, nextNodeInList);
        }
    }

    static class SinglyLinkedListNode {

        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }

    }

    static class SinglyLinkedList {

        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }

        public static void printElements(SinglyLinkedListNode node) {
            StringBuilder content = new StringBuilder();
            while (node != null) {
                content.append(String.valueOf(node.data));
                node = node.next;
                System.out.println("print " + node);
                if (node != null) {
                    content.append("\t");
                }
            }
            System.out.println(content);
        }

    }
}
