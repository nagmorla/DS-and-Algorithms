package dsalg;

/**
 *
 * @author nmorla
 * @since Aug 25, 2020
 */
public class BinarySearch {

    public static void main(String[] args) {
//        int arrSize = 10;
//        int findElement = 19;
        int arrSize = Integer.parseInt(args[0]);
        int findElement = Integer.parseInt(args[1]);
        int[] array = new int[arrSize];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 10;
        }
        System.out.println("Start iterative search");
        long lStartTime = System.nanoTime();
        int index = findElement1(array, findElement);
        long lEndTime = System.nanoTime();
        System.out.println("End iterative search -> " + index + ", Time :: " + (lEndTime - lStartTime) / 1000000);
        System.out.println("Start recursive search");
        lStartTime = System.nanoTime();
        index = findElement2(array, findElement, 0, array.length - 1);
        lEndTime = System.nanoTime();
        System.out.println("End  recursive search -> " + index + ", Time :: " + (lEndTime - lStartTime) / 1000000);
    }

    static int findElement1(int[] arr, int ele) {
        int left = 0, right = arr.length - 1, mid;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (arr[mid] == ele) {
                return mid;
            } else if (ele > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    static int findElement2(int[] arr, int ele, int left, int right) {
        if (left <= right) {
            int mid = (right - left) / 2 + left;
            if (arr[mid] == ele) {
                return mid;
            } else if (ele > arr[mid]) {
                left = mid + 1;
                return findElement2(arr, ele, left, right);
            } else {
                right = mid - 1;
                return findElement2(arr, ele, left, right);
            }
        }
        return -1;
    }
}
