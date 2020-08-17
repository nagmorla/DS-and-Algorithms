package dsalg;

/**
 *
 * @author nmorla
 * @since Aug 17, 2020
 */
public class MyLinkedList {

    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.printElements();
        System.out.println("===============");
//        Load data into LinkedList
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
//        Print the data
        list.printElements();
        System.out.println("===============");
//Check if linked list has an element
        System.out.println("List has 50 <==> " + list.contains(50));
        System.out.println("List has 5 <==> " + list.contains(5));
    }
}

class SingleLinkedList<T> {

    private Node head;
    private Node tail;

    public SingleLinkedList() {
        head = null;
        tail = null;
    }

    public void add(T t) {
        Node<T> n = new Node(t);
        if (head == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = tail.next;
        }
    }

    public void printElements() {
        if (head == null) {
            System.out.println("No Data");
            return;
        }
        Node t = head;
        while (t != null) {
            System.out.println("--> " + t.data);
            t = t.next;
        }
    }

    public boolean contains(T v) {
        if (head == null) {
            System.out.println("No Data");
            return false;
        }
        Node t = head;
        while (t != null) {
            if (t.data.equals(v)) {
                return true;
            }
            t = t.next;
        }
        return false;
    }

    class Node<T> {

        T data;
        Node next;

        public Node(T data) {
            this.data = data;
        }

    }
}
