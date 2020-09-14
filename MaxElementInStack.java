package dsalg;

import java.util.Scanner;

/**
 *
 * @author nmorla
 * @since Aug 27, 2020
 */
public class MaxElementInStack {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StackWithArray<Integer> elements = new StackWithArray<>();
        StackWithArray<Integer> maxElements = new StackWithArray<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    int val = sc.nextInt();
                    elements.push(val);
                    if (max <= val) {
                        max = val;
                        maxElements.push(max);
                    }
                    break;

                case 2:
                    if (!elements.isEmpty()) {
                        int delVal = elements.pop();
                        if (maxElements.peek() == delVal) {
                            maxElements.pop();
                            max = (maxElements.peek() == null ? new Integer(0) : maxElements.peek());
                        }
                    }
                    break;

                case 3:
                    System.out.println(maxElements.peek());
                    break;
                default:
                    System.out.println("Wrong Choice");
            }
        }
        sc.close();
    }

}
