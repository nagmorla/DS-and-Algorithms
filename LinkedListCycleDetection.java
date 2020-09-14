package dsalg;

import dsalg.SingleLinkedListLeverse.SinglyLinkedList;
import dsalg.SingleLinkedListLeverse.SinglyLinkedListNode;

/**
 *
 * @author nmorla
 * @since Aug 23, 2020
 */
public class LinkedListCycleDetection {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        for (int i = 0; i < 5; i++) {
            list.insertNode(i * 3);
        }
        list.printElements(list.head);
        list.tail.next = list.head.next.next.next;
//        list.printElements(list.head);
        SinglyLinkedListNode node = list.head;
        while (node.next != null) {
            if (contains(node)) {
                System.out.println("Loop detected with - " + node.data);
                break;
            }
            push(node);
            node = node.next;
        }
    }
    static Object[] elements = new Object[10];
    static private int count;

    public static boolean contains(Object t) {
        for (Object element : elements) {
            if (t.equals(element)) {
                return true;
            }
        }
        return false;
    }

    synchronized static public void push(Object t) {
        ensureCapacity();
        elements[count++] = t;
    }

    private static void ensureCapacity() {
        if (count >= elements.length) {
            Object[] newArray = new Object[count << 1];
            System.arraycopy(elements, 0, newArray, 0, count);
            elements = newArray;
        }
    }
}
