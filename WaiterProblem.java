/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsalg;

import java.util.Arrays;

/**
 *
 * @author nmorla
 * @since Sep 8, 2020
 */
public class WaiterProblem {

    public static void main(String[] args) {
        int[] values = {3, 4, 7, 6, 5};
        int w[] = waiter(values, 1);
        System.out.println(" --> " + Arrays.toString(w));
    }

    static int[] waiter(int[] number, int q) {
        int[] primes = getPrimes(q);
        StackWithArray<Integer> a1 = new StackWithArray<>(1000);
        StackWithArray<Integer> a2 = new StackWithArray<>(1000);
        StackWithArray[] bStacks = new StackWithArray[q];
        int[] orderedPlates = new int[number.length];
        for (int i = 0; i < number.length; i++) {
            a1.push(number[i]);
        }
        doRecurssion(a1, a2, bStacks, primes, 1, q);
        //Copy bstacks elements to array.
        int opCnt = 0;
        for (int i = 0; i < q; i++) {
            StackWithArray<Integer> bSt = bStacks[i];
//            System.out.println("BST :: " + bSt);
            Integer bstEle = bSt.pop();
            while (bstEle != null) {
//                System.out.println("bst Ele " + bstEle);
                orderedPlates[opCnt++] = bstEle;
                bstEle = bSt.pop();
            }
        }
        //Copy a1/a2 elements as well
        StackWithArray<Integer> a;
        if (q % 2 == 0) {
            a = a1;
        } else {
            a = a2;
        }
        Integer astEle = a.pop();
        while (astEle != null) {
            orderedPlates[opCnt++] = astEle;
            astEle = a.pop();
        }
        return orderedPlates;
    }

    static void doRecurssion(StackWithArray<Integer> a1, StackWithArray<Integer> a2, StackWithArray[] bStacks, int[] primes, int iter, int q) {
        Integer stackEle = a1.pop();
        StackWithArray<Integer> b = new StackWithArray<>(100);
        while (stackEle != null) {
            if ((stackEle % primes[iter - 1]) == 0) {
                b.push(stackEle);
            } else {
                a2.push(stackEle);
            }
            stackEle = a1.pop();
        }
        bStacks[iter - 1] = b;
        if (++iter > q) {
            return;
        } else {
            doRecurssion(a2, a1, bStacks, primes, iter, q);
        }
    }

    static int[] getPrimes(int n) {
        int[] primes = new int[n];
        if (n >= 1) {
            primes[0] = 2;
        }
        for (int i = 1; i < n; i++) {
            int pri = 0;
            for (int j = primes[i - 1] + 1; j < Integer.MAX_VALUE; j++) {
                if (isPrime(j)) {
                    pri = j;
                    break;
                }
            }
            primes[i] = pri;

        }
        return primes;
    }

    static boolean isPrime(int n) {
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
