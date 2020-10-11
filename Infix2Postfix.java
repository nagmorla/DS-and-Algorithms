package dsalg;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 *
 * @author nmorla
 * @since Oct 11, 2020
 */
public class Infix2Postfix {

    public static void main(String[] args) {
        String expression = "A+B-C*D-E/F-(H/J)";
        Stack<String> operators = new Stack<>();
        StringTokenizer tokens = new StringTokenizer(expression, "+-*/^()", true);
//        System.out.println("<<-->>" + tokens.countTokens());
        StringBuilder requiredExp = new StringBuilder();
        while (tokens.hasMoreTokens()) {
            String t = tokens.nextToken();
//            System.out.println(t);
            switch (t) {
                case "+":
                case "-":
                    while (!operators.isEmpty() && !operators.peek().equals("(")) {
                        requiredExp.append(operators.pop());
                    }
                    operators.push(t);
                    break;
                case "*":
                case "/":
                    while (!operators.isEmpty() && !operators.peek().equals("(")) {
                        String op = operators.peek();
                        if (op.equals("/") || op.equals("*")) {
                            requiredExp.append(operators.pop());
                        } else {
                            break;
                        }
                    }
                    operators.push(t);
                    break;
                case "(":
                    operators.push(t);
                    break;
                case ")":
                    String p;
                    while (!"(".equals(p = operators.peek()) && !p.isEmpty()) {
                        requiredExp.append(p);
                        operators.pop();
                    }
                    if (p.isEmpty()) {
                        throw new java.lang.IllegalArgumentException("Invalid no.of paranthsis.");
                    } else {
                        operators.pop();
                    }
                    break;
                default:
                    requiredExp.append(t);
            }
        }
        while (!operators.isEmpty()) {
            final String pop = operators.pop();
            if (pop.equals("(")) {
                throw new java.lang.IllegalArgumentException("Invalid no.of paranthsis.");
            } else {
                requiredExp.append(pop);
            }
        }
        System.out.println("Postfix Expression :: " + requiredExp);
    }
}
