package dsalg;

import java.util.Stack;

/**
 *
 * @author nmorla
 * @since Oct 11, 2020
 */
public class PostfixEvaluation {

    public static void main(String[] args) {
        //Infix: A+B-C*D-E/F-(H/J)
        //Postfix: AB+CD*-EF/-HJ/-
//        String infixExpression = "5+6-7*8-4/2-6/2";
        String postfixExpression = "56+78*-42/-62/-";
        char[] ch = postfixExpression.toCharArray();
        Stack<Integer> st = new Stack<>();
        for (char c : ch) {
            switch (c) {
                case '+':
                    st.push(st.pop() + st.pop());
                    break;
                case '-':
                    st.push(-st.pop() + st.pop());
                    break;
                case '*':
                    st.push(st.pop() * st.pop());
//                    System.out.println("Multiplied :: " + st);
                    break;
                case '/':
                    float second = st.pop();
                    float first = st.pop();
                    st.push((int) (first / second));
//                    System.out.println("Devided :: " + st);
                    break;
                default:
//                    System.out.println("-- " + ((int) c - 48));
                    st.push((int) c - 48);
            }
        }
        System.out.println("Evaluated :: " + st.pop());
    }

}
