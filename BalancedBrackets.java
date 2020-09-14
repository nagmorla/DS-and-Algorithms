package dsalg;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nmorla
 * @since Aug 23, 2020
 */
public class BalancedBrackets {

    public static void main(String[] args) {
        System.out.println("" + isBalanced("{{)[](}}"));
    }
    // Complete the isBalanced function below.
    private static Map<Character, Character> map = new HashMap<>();

    static {
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');
    }

    static String isBalanced(String s) {
        char[] ch = s.toCharArray();
        int len = ch.length;
        if (len % 2 != 0) {
            return "NO";
        }
        StackWithArray<Character> st1 = new StackWithArray<>();
        StackWithArray<Character> st2 = new StackWithArray<>();
        for (char c : ch) {
            st1.push(c);
        }
        if (removePair(st1, st2)) {
            return "YES";
        }
        return "NO";
    }

    static boolean removePair(StackWithArray<Character> st1, StackWithArray<Character> st2) {
        if (st1.size() == 0) {
            return true;
        }
        st2.push(st1.pop());
        Character c1 = st1.pop();
        Character c2 = st2.peek();
        boolean match = false;
        while (c1 != null) {
//            System.out.println(c1 + " <--> " + c2);
            if (c2 != null && map.get(c1) != null && map.get(c1).equals(c2)) {
//                System.out.println("equals");
                st2.pop();
                match = true;
//                continue;
            } else {
                st2.push(c1);
            }
            c1 = st1.pop();
            c2 = st2.peek();
        }
        System.out.println("" + match);
        Character c ;
        while ((c = st2.pop()) != null) {
            st1.push(c);
        }
        if (match) {
            return removePair(st1, st2);
        }
        return false;
    }

}
