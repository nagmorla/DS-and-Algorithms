package dsalg;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

/**
 *
 * @author nmorla
 * @since Sep 7, 2020
 */
public class BitwiseOperators {


    /*
     * Complete the andXorOr function below.
     */
    static int andXorOr(int[] a) {
        /*
         * Write your code here.
         */
        return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

//        int aCount = Integer.parseInt(scanner.nextLine().trim());
//        int[] a = new int[aCount];
//        String[] aItems = scanner.nextLine().split(" ");
//        for (int aItr = 0; aItr < aCount; aItr++) {
//            int aItem = Integer.parseInt(aItems[aItr].trim());
//            a[aItr] = aItem;
//        }
//        int result = andXorOr(a);
//        System.out.println("Maximum value after expression :: " + result);
        int x = 2, y = 3;
        System.out.println("" + (((x & y) ^ (x | y)) & (x ^ y)));
        x = 12;
        y = 9;
        System.out.println("" + (((x & y) ^ (x | y)) & (x ^ y)));
        x = 10;
        y = 19;
        System.out.println("" + (((x & y) ^ (x | y)) & (x ^ y)));
    }
}
