package dsalg;

/**
 *
 * @author nmorla
 * @since Aug 20, 2020
 */
public class StacksTestUtil {

    public static void main(String[] args) {
//        int val = Integer.MAX_VALUE;
//        System.out.println("" + (val << 2));
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
        testArrayBased();
        System.out.println("=========================");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("=========================");
        testLinkedListBased();
    }

    private static void testArrayBased() {

        StackWithArray<Integer> st = new StackWithArray<>();
//        System.out.println("Poped :: " + st.pop());
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

    private static void testLinkedListBased() {

        StackWithLinkedList<Integer> st = new StackWithLinkedList<>();
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
