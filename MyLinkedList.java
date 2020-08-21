package dsalg;

/**
 *
 * @author nmorla
 * @since Aug 17, 2020
 */
public class MyLinkedList {

    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = o1;
        System.out.println(" " + (o1 == o2));

        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.remove(0);
        System.out.println("===============" + list.size() + " - " + list.getLast());
        list.printElements();
        System.out.println("===============" + list.size() + " - " + list.getLast());
        list.add(0, 10);
        list.printElements();
        System.out.println("===============" + list.size() + " - " + list.getLast());
        list.add(0, 15);
        list.printElements();
        System.out.println("===============" + list.size() + " - " + list.getLast());
        list.add(0, 5);
        list.printElements();
        System.out.println("===============" + list.size() + " - " + list.getLast());
        list.add(3, 23);
        list.printElements();
        System.out.println("===============" + list.size() + " <--> " + list.getLast());
//        Load data into LinkedList
        for (int i = 5; i < 10; i++) {
            list.add(i);
        }
//        Print the data
        list.printElements();
        System.out.println("===============" + list.size() + " <-> " + list.getLast());
        list.addFirst(200);
        list.printElements();
        System.out.println("===============" + list.size() + " <-> " + list.getLast());
        list.addLast(-50);
        list.printElements();
        System.out.println("===============" + list.size() + " <--> " + list.getLast());
//Check if linked list has an element
        System.out.println("List has 50 <==> " + list.contains(50));
        System.out.println("List has 5 <==> " + list.contains(5));
        list.remove(0);
        list.printElements();
        System.out.println("===============" + list.size() + " <-> " + list.getLast());
        list.removeLast();
        list.printElements();
        System.out.println("===============" + list.size() + " <-> " + list.getLast());
    }
}

class SingleLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public SingleLinkedList() {
        head = null;
        tail = null;
    }

    /**
     * Add element to tail of the list;
     *
     * @param t
     */
    public void add(T t) {
//        Node<T> n = new Node(t);
//        if (head == null) {
//            head = n;
//            tail = n;
//        } else {
//            tail.next = n;
//            tail = tail.next;
//        }
        add(size, t);
    }

    public int size() {
        return size;
    }

    public void printElements() {
        if (head == null) {
            System.out.println("No Data");
            return;
        }
        Node t = head;
        while (t != null) {
            System.out.print(t.data + "\t");
            t = t.next;
        }
        System.out.println("");
    }

    /**
     * Adds element at given index.
     *
     * @param index
     * @param element
     */
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("LinkedList size::" + size + ", Given index :: " + index);
        }
        Node n = new Node(element);
        if (index == 0) {
            Node t = head;
            head = n;
            n.next = t;
            tail = tail == null ? head : tail;
        } else if (index == size) {
//            System.out.println("index == size, adding at tail");
            tail.next = n;
            tail = tail.next;
        } else {
            int i = 0;
            Node firstPart = head;
            while (i < index - 1) {
                firstPart = firstPart.next;
                i++;
            }
            if (firstPart == tail) {
                tail = n;
            }
            Node secondPart = firstPart.next;
            firstPart.next = n;
            n.next = secondPart;
        }
        size++;
    }

    /**
     * Retrieves but doesn't removes tailing element.
     *
     * @return
     */
    public T getLast() {
        if (tail == null) {
            return null;
        }
        return tail.data;
    }

    /**
     * Retrieves but doesn't removes head element.
     *
     * @return
     */
    public T getFirst() {
        if (head == null) {
            return null;
        }
        return head.data;
    }

    /**
     * Deletes element in the list at given position.
     *
     * @param index
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("LinkedList size::" + size + ", Given index :: " + index);
        }
        T t;
        if (index == 0) {
            t = head.data;
            head = head.next;
            tail = head == null ? null : tail;
        } else {
            int i = 0;
            Node<T> elem = head;
            Node<T> prev = head;
            while (i < index) {
                prev = elem;
                elem = elem.next;
                i++;
            }
            prev.next = elem.next;
            t = elem.data;
            if (elem == tail) {
                tail = prev;
            }
        }
        size--;
        return t;
    }

    /**
     * Removes tailing element.
     */
    public void removeLast() {
        remove(size - 1);
    }

    /**
     * Adds element to head of the element.
     *
     * @param ele
     */
    public void addFirst(T ele) {
        add(0, ele);
    }

    /**
     * Adds element to tail in the list.
     *
     * @param ele
     */
    public void addLast(T ele) {
        add(size, ele);
    }

    /**
     * Retrieves and removes head element.
     *
     * @return
     */
    public T poll() {
        if (head == null) {
            return null;
        }
//        T t = head.data;
//        head = head.next;
//        size--;
//        if (head == null) {
//            tail = null;
//        }
//        return t;
        return remove(0);
    }

    /**
     * Retrieves and removes head element.
     *
     * @return
     */
    public T pop() {
        if (head == null) {
            return null;
        }
//        T t = head.data;
//        head = head.next;
//        if (head == null) {
//            tail = null;
//        }
//        size--;
//        return t;
        return remove(0);
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

    /**
     * Internal data container to hold each element(node) data.
     *
     * @param <T>
     */
    private class Node<T> {

        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
        }

    }
}
