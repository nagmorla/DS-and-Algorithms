package dsalg;

/**
 * Stack's default behaviour is LIFO, when element is pushed, it will be added
 * to top of the stack. When element is popped, top element will be retrieved
 * and removed. It supports stack operations like pop(), peek(), push(e) .. etc.
 * This implementation is backed by plain array.
 *
 * @author nmorla
 * @param <T>
 * @since Aug 21, 2020
 */
public class StackWithArray<T> {

    private Object[] elements;
    private int count;

    public StackWithArray(int size) {
        elements = new Object[size];
    }

    public StackWithArray() {
        elements = new Object[5];
    }

    public void printElements() {
        for (Object element : elements) {
            System.out.print(element + "\t");
        }
        System.out.println("");
    }

    /**
     * Retrieves element from top of the stack but do not remove.
     *
     * @return top element from stack.
     */
    public synchronized T pop() {
        if (count == 0) {
            return null;
        }
        T t = (T) elements[--count];
        elements[count] = null;//De-reference the old element.
        return t;
    }

    /**
     * Verifies if given element exists in stack.
     *
     * @param t
     * @return true if element exists in stack.
     */
    public boolean contains(T t) {
        for (int i = 0; i < count; i++) {
            if (t.equals(elements[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves element from top of the stack but do not remove.
     *
     * @return top element from stack.
     */
    public T peek() {
        if (count == 0) {
            return null;
        }
        return (T) elements[count - 1];
    }

    /**
     * Pushes element to top of the stack.
     *
     * @param t
     */
    synchronized public void push(T t) {
        ensureCapacity();
        elements[count++] = t;
    }

    /**
     * Gives stacks current size/no.of elements exists in stack.
     *
     * @return Size of the stack.
     */
    public int size() {
        return count;
    }

    /**
     * Verifies if stack is empty.
     *
     * @return true if stack is empty.
     */
    public boolean isEmpty() {
        return count == 0;
    }

    private void ensureCapacity() {
        if (count >= elements.length) {
            //Double the zise
//            System.out.println("Old array reached max-threashold.. " + Arrays.toString(elements));
            Object[] newArray = new Object[count << 1];
            System.arraycopy(elements, 0, newArray, 0, count);
            elements = newArray;
//            System.out.println("New array created.. " + Arrays.toString(elements));
        }
    }

}
