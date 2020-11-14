package dsalg;

import java.util.Arrays;

/**
 *
 * @author nmorla
 * @since Nov 14, 2020
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 6, 7, 8};
        System.out.println("-->" + Arrays.toString(arr));
//        descendingSort(arr);
        assendingSort(arr);
        System.out.println("-->" + Arrays.toString(arr));
    }

    static void descendingSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] > arr[j - 1]; j--) {
//                System.out.println(arr[j] + "---" + arr[j - 1]);
                swap(j, j - 1, arr);
            }
        }
    }
    static void assendingSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
//                System.out.println(arr[j] + "---" + arr[j - 1]);
                swap(j, j - 1, arr);
            }
        }
    }

    private static void swap(int indx1, int indx2, int[] arr) {
        int t = arr[indx1];
        arr[indx1] = arr[indx2];
        arr[indx2] = t;
    }
}
