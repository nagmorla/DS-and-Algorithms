package dsalg;

/**
 *
 * @author nmorla
 * @since Aug 20, 2020
 */
public class StackWithLinkedListImpl {

    public static void main(String[] args) {

        MyStack<Integer> st = new MyStack<>();
        st.add(2);
        if (st.pop() == 2) {
            System.out.println("Poped is 2");
        } else {
            System.out.println("Poped is not 2");
        }
        st.add(7);
        st.add(4);
        st.add(6);
        st.add(0);
        st.add(1);
        st.printElements();
        st.add(10);
        st.add(-9);
        st.printElements();
        System.out.println("Peeked :: " + st.peek());
        st.printElements();
        System.out.println("Poped :: " + st.pop());
        System.out.println("Poped :: " + st.pop());
        st.printElements();
        st.add(101);
        st.add(214);
        st.printElements();
    }
}

class MyStack<T> {

    private final SingleLinkedList<T> list = new SingleLinkedList<>();

    public MyStack() {
    }

    public void printElements() {
        list.printElements();
    }

    /**
     * Retrieves element from top of the stack but do not remove.
     *
     * @return top element from stack.
     */
    public synchronized T pop() {
        return list.pop();
    }

    public boolean contains(T t) {
        return list.contains(t);
    }

    /**
     * Retrieves element from top of the stack but do not remove.
     *
     * @return top element from stack.
     */
    public T peek() {
        return list.getFirst();
    }

    /**
     * Add element to tail of queue.
     *
     * @param t
     */
    synchronized public void add(T t) {
        list.add(t);
    }

    public int size() {
        return list.size();
    }

}
