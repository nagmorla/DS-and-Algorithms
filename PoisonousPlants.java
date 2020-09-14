package dsalg;

import java.io.*;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author nmorla
 * @since Aug 27, 2020
 */
public class PoisonousPlants {

    static int poisonousPlants4(int[] p) {
        StackWithArray<Integer> poisonesTrees = new StackWithArray<>();
        StackWithArray<Integer> dayofTrees = new StackWithArray<>();
        int minElement = p[0];
        poisonesTrees.push(p[0]);
        dayofTrees.push(0);
        int days = 0;
        for (int i = 1; i < p.length; i++) {
            int popedTreesMaxPoisonLevel = -1;
            while (poisonesTrees.peek() >= p[i] && poisonesTrees.peek() != minElement) {
                poisonesTrees.pop();
                int level = dayofTrees.pop();
                if (popedTreesMaxPoisonLevel < level) {
                    popedTreesMaxPoisonLevel = level;
                }
            }
            if (p[i] <= minElement) {
                minElement = p[i];
                poisonesTrees.push(p[i]);
                dayofTrees.push(0);
            } else {
                poisonesTrees.push(p[i]);
                if (popedTreesMaxPoisonLevel == -1) {
                    //Nothing has been popped up.
                    dayofTrees.push(1);
                } else {
                    //Some elements popped. So increase the level.
                    dayofTrees.push(popedTreesMaxPoisonLevel + 1);
                }
            }
            if (days < dayofTrees.peek()) {
                days = dayofTrees.peek();
            }
        }
        return days;
    }

    /**
     * Without temp array. time complexity O(n^2)
     */
    static int poisonousPlants1(int[] p) {
        boolean died = false;
        int count = 0, temp = -1;
        do {
            int prev = p[0];
            died = false;
            for (int i = 1; i < p.length; i++) {
                temp = p[i];
                if (p[i] > prev) {
                    p[i] = -1;
                    died = true;
                }
                if (temp >= 0) {
                    prev = temp;
                }
            }
            if (died) {
                count++;
            }
        } while (died);
        return count;
    }

    static int poisonousPlants3(int[] p) {
        StackWithArray<Integer> st = new StackWithArray<>();
        int minElement = p[0];
        st.push(p[0]);
        int days = 0;
        for (int i = 1; i < p.length; i++) {
            if (p[i] <= minElement) {
                minElement = p[i];
//                st.push(p[i]);
            } else if (p[i] > p[i - 1]) {
                days = days == 0 ? 1 : days;
            } else if (p[i] < p[i - 1] && p[i] <= st.peek() && p[i] > minElement) {
                st.push(p[i]);
                days++;
            }

        }
        return days;
    }

    /**
     * Not used aux array, time complexity is O(n)
     *
     * @param p
     * @return
     */
    static int poisonousPlants2(int[] p) {
        int temp;
        int minElement = p[0];
        int maxDays = 0;
        int days = 0;
        for (int i = 1; i < p.length; i++) {
            temp = p[i];
            if (p[i] > p[i - 1]) {
                if (days == 0) {
                    days = 1;
                }
            } else if (p[i] < p[i - 1] && p[i] > minElement) {
                days++;
            }
            if (temp < minElement) {
                minElement = temp;
                if (maxDays < days) {
                    maxDays = days;
                }
                days = 0;
            }
        }
        if (maxDays < days) {
            maxDays = days;
        }
        return maxDays;
    }
//    static int poisonousPlants2(int[] p) {
//        int temp = -1;
//        int prev = p[0];
//        int maxDays = 0;
//        int days = 0;
//        for (int i = 1; i < p.length; i++) {
//            temp = p[i];
//            if (p[i] > p[i - 1]) {
//                if (maxDays < days) {
//                    maxDays = days;
//                }
//                days = 1;
//            } else if (p[i] < p[i - 1] && p[i] > prev) {
//                days++;
//            }
//            if (temp < prev) {
//                prev = temp;
//            }
//        }
//        if (maxDays < days) {
//            maxDays = days;
//        }
//        return maxDays;
//    }

    /**
     * With 1 temp array. Time complexity is O(n^2), but surely it gives better
     * performance than solution 1 as we don't scan entire array in subsequent
     * calls when elements are removed.
     */
    static int poisonousPlants(int[] p) {
        int dayCount = 0, delCount = 0;
        int n = p.length;
        int[] aux = new int[n];
        int[] a = p;
        int[] b = aux;
        do {
            int prev = a[0];
            int auxCnt = 0;
            b[auxCnt++] = a[0];
            delCount = 0;
            for (int i = 1; i < n; i++) {
                if (a[i] > a[i - 1]) {
                    delCount++;
                } else {
                    b[auxCnt++] = a[i];
                }
            }
            if (delCount > 0) {
                dayCount++;
                n = auxCnt;
                int[] t = a;
                a = b;
                b = t;
            }
        } while (delCount > 0);
        return dayCount;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = 100000;
        int[] p = new int[n];
        System.out.println("Enter space separated input::");
        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        System.out.println(new Date() + " Scanner read complete, assigning them to array");
        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pItems[i]);
            p[i] = pItem;
        }
        scanner.close();
        System.out.println(new Date() + " Len -- " + p.length);
        long lStartTime = System.nanoTime();
        // Time : 8711 ms, Ans: 99900
        // int result = poisonousPlants(p);
        // Time 11344 ms, Ans: 99900
        // int result = poisonousPlants1(p);
        // Time 4 ms, Ans: 99900
        int result = poisonousPlants2(p);
        long lEndTime = System.nanoTime();
        System.out.println(new Date() + " Result :: " + result + ", Time Taken :: " + (lEndTime - lStartTime) / 1000000);
        lStartTime = System.nanoTime();
        result = poisonousPlants3(p);
        lEndTime = System.nanoTime();
        System.out.println(new Date() + " Result :: " + result + ", Time Taken :: " + (lEndTime - lStartTime) / 1000000);
        lStartTime = System.nanoTime();
        result = poisonousPlants4(p);
        lEndTime = System.nanoTime();
        System.out.println(new Date() + " Result :: " + result + ", Time Taken :: " + (lEndTime - lStartTime) / 1000000);
    }
}
