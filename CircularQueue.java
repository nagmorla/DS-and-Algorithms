package dsalg;

/**
 * This is capacity bounded circular queue. Offers basic functionality like
 * enqueue(e), dequeue(), size(), isEmpty(), contains(e).
 *
 * @author nmorla
 * @param <T>
 * @since Aug 22, 2020
 */
public class CircularQueue<T> {

    public static void main(String[] args) throws Exception {
        CircularQueue<Integer> cQ = new CircularQueue<>(5);
        cQ.enqueue(2);
        cQ.enqueue(1);
        cQ.print();
        cQ.enqueue(3);
        cQ.print();
        cQ.enqueue(12);
        cQ.enqueue(8);
        cQ.print();
        System.out.println(" Dequeue --> " + cQ.dequeue());
        cQ.enqueue(18);
        cQ.print();
        System.out.println(" Dequeue --> " + cQ.dequeue());
        System.out.println(" Dequeue --> " + cQ.dequeue());
        System.out.println(" Dequeue --> " + cQ.dequeue());
        System.out.println(" Dequeue --> " + cQ.dequeue());
        System.out.println(" Dequeue --> " + cQ.dequeue());
        cQ.print();
//        System.out.println(" Dequeue --> " + cQ.dequeue());
        cQ.enqueue(12);
        cQ.enqueue(8);
        cQ.print();
    }
    private int front = -1;
    private int rear = -1;
    private int size;
    private final int capacity;
    private final Object[] elements;

    /**
     * Creates queue with bounded capacity.
     *
     * @param capacity
     */
    public CircularQueue(int capacity) {
        this.capacity = capacity;
        elements = new Object[capacity];
    }

    /**
     * Adds element at rear(end) of the queue. If queue is full, throws
     * exception.
     *
     * @param t Element to be added.
     * @throws Exception is queue is full.
     */
    synchronized public void enqueue(T t) throws Exception {
        if (isQueueFull()) {
            throw new Exception("Queue is Full");
        }
        rear = (rear + 1) % capacity;
        elements[rear] = t;
        if (front == -1) {
            front = rear;
        }
        size++;
    }

    /**
     *
     * Removes element from front of the queue. If queue is empty, throws
     * exception.
     *
     * @throws Exception is queue is empty.
     * @return Element removed from front of queue.
     */
    synchronized public T dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Empty Queue");
        }
        T t = (T) elements[front];
        elements[front] = null;//Nullify it to make sure obj is GC.
        front = (front + 1) % capacity;
        size--;
        if (size == 0) {
            front = rear = -1;
        }
        return t;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("No Elements in Queue");
        }
        int start = front;
        for (int i = 0; i < size; i++) {
            System.out.print(elements[start % capacity] + "\t");
            start++;
        }
        System.out.println("");
    }

    /**
     * Verifies if queue is full.
     *
     * @return
     */
    public boolean isQueueFull() {
        return ((rear - front) + 1) % capacity == 0;
    }

    /**
     * Gives size(no.of elements) of queue.
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * Verifies if queue is empty.
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Verifies if gives element exists in queue.
     *
     * @param t
     * @return
     */
    public boolean contains(T t) {
        //Yet to be implemented.
        return true;
    }
}
