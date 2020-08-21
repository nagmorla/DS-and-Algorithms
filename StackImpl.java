package dsalg;

import java.util.Arrays;
import java.util.Vector;

/**
 *
 * @author nmorla
 * @since Aug 20, 2020
 */
public class StackImpl {

    public static void main(String[] args) {
        int val = Integer.MAX_VALUE;
//        Vector v;
        System.out.println("" + (val << 2));
//        System.out.println("" + (1 >> 2));
//        System.out.println("" + (1 >> 1));
//        System.out.println("" + (4 >> 1));
//        System.out.println("==========");
//        System.out.println("" + (-4 >> 1));
//        System.out.println("" + (-4 >> 2));
//        System.out.println("" + (-4 >> 3));
//        System.out.println("" + (-4 >> 4));
//        System.out.println("" + (-4 >>> 35));
//        HashMap<Character, Character> charMap = new HashMap<>();
//        charMap.put('{', '}');
//        charMap.containsValue('}');
        MyStackV1<Integer> st = new MyStackV1<>();
        System.out.println("Peeked :: " + st.peek());
        System.out.println("Poped :: " + st.pop());
        st.push(2);
        if (st.pop() == 2) {
            System.out.println("Poped is 2");
        } else {
            System.out.println("Poped is not 2");
        }
        st.push(2);
        st.push(4);
        st.push(6);
        st.push(0);
        st.push(1);
        st.printElements();
        st.push(10);
        st.push(-9);
        st.printElements();
        System.out.println("Peeked :: " + st.peek());
        st.printElements();
        System.out.println("Poped :: " + st.pop());
        System.out.println("Poped :: " + st.pop());
        st.printElements();
        st.push(101);
        st.push(214);
        st.printElements();
    }
}

class MyStackV1<T> {

    private Object[] elements;
    private int count;

    public MyStackV1(int size) {
        elements = new Object[size];
    }

    public MyStackV1() {
        elements = new Object[5];
    }

    public void printElements() {
        for (Object element : elements) {
            System.out.print(" " + element);
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

    public int size() {
        return count;
    }

    private void ensureCapacity() {
        if (count >= elements.length) {
            //Double the zise
            System.out.println("Old array reached max-threashold.. " + Arrays.toString(elements));
            Object[] newArray = new Object[count << 1];
            System.arraycopy(elements, 0, newArray, 0, count);
            elements = newArray;
            System.out.println("New array created.. " + Arrays.toString(elements));
        }
    }
}
