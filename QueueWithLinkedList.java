package dsalg;

/**
 * Queue's default behaviour is FIFO. Element added first is the element pops
 * first.
 *
 * @author nmorla
 * @param <T>
 * @since Aug 21, 2020
 */
public class QueueWithLinkedList<T> {

    private final SingleLinkedList<T> list = new SingleLinkedList<>();

    public QueueWithLinkedList() {
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

    /**
     * Verifies if given element exists in queue.
     *
     * @param t
     * @return true is element exists in queue.
     */
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

    /**
     * Verifies if the queue is empty.
     *
     * @return true if queue is empty.
     */
    public boolean isEmpty() {
        return list.size() == 0;
    }
}
