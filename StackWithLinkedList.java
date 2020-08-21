package dsalg;

/**
 * Default stack behaviour is LIFO, Last element pushed into stack will be
 * popped first. It supports basic operations like push(e), pop(), peek(),
 * size().. etc, This stack implementation is backed by SingleLinkedList
 *
 * @author nmorla
 * @param <T> Generic element type.
 * @since Aug 21, 2020
 */
public class StackWithLinkedList<T> {

    private final SingleLinkedList<T> list = new SingleLinkedList<>();

    public StackWithLinkedList() {
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
        return list.removeLast();
    }

    /**
     * Verifies whether given element exists in the stack.
     *
     * @param element
     * @return true if element exists.
     */
    public boolean contains(T element) {
        return list.contains(element);
    }

    /**
     * Retrieves element from top of the stack but do not remove.
     *
     * @return top element from stack.
     */
    public T peek() {
        return list.getLast();
    }

    /**
     * Pushes element to top of the stack.
     *
     * @param element element to be pushed.
     */
    synchronized public void push(T element) {
        list.add(element);
    }

    /**
     * Gives current size of the the stack.
     *
     * @return Size of the the stack
     */
    public int size() {
        return list.size();
    }

    /**
     * Check if stack is empty.
     *
     * @return true of stack is empty.
     */
    public boolean isEmpty() {
        return list.size() == 0;
    }
}
