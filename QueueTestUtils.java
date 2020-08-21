package dsalg;

/**
 *
 * @author nmorla
 * @since Aug 20, 2020
 */
public class QueueTestUtils {

    public static void main(String[] args) {

        QueueWithLinkedList<Integer> st = new QueueWithLinkedList<>();
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