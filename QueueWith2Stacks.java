package dsalg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 *
 * @author nmorla
 * @since Sep 3, 2020
 */
public class QueueWith2Stacks {

    public static void main(String[] args) throws IOException {
        solution1();
    }

    private static void solution1() throws IOException {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String nextLine = br.readLine();
            int choice = nextLine.charAt(0) - 48;
            switch (choice) {
                case 1:
                    String val = nextLine.substring(2);
//                    System.out.println("============ push [" + val + "]");
                    st1.push(Integer.parseInt(val));
                    break;

                case 2:
                    //Reverse stack to bring front elements to top.
                    if (st2.empty()) {
                        while (!st1.empty()) {
                            st2.push(st1.pop());
                        }
                    }
                    st2.pop();
                    //Reverse stack to restore the elements order.
//                    while (!st2.empty()) {
//                        st1.push(st2.pop());
//                    }
                    break;

                case 3:
                    if (st2.empty()) {
                        while (!st1.empty()) {
                            st2.push(st1.pop());
                        }
                    }
                    System.out.println(st2.peek());
                    break;

                default:
                    System.out.println("Wrong Choice");
            }
        }
        br.close();
    }

    private static void solution2() throws Exception {
        StackWithArray<Integer> st1 = new StackWithArray<>(1000000);
        StackWithArray<Integer> st2 = new StackWithArray<>(1000000);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String nextLine = br.readLine();
            int choice = nextLine.charAt(0) - 48;
            switch (choice) {
                case 1:
                    String val = nextLine.substring(2);
//                    System.out.println("============ push [" + val + "]");
                    st1.push(Integer.parseInt(val));
                    break;

                case 2:
                    //Reverse stack to bring front elements to top.
                    while (!st1.isEmpty()) {
                        st2.push(st1.pop());
                    }
                    st2.pop();
                    //Reverse stack to restore the elements order.
                    while (!st2.isEmpty()) {
                        st1.push(st2.pop());
                    }
                    break;

                case 3:
                    System.out.println(st1.getElementFromBottom(1));
                    break;

                default:
                    System.out.println("Wrong Choice");
            }
        }
        br.close();
    }

}
