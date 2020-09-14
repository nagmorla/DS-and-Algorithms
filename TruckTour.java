package dsalg;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

/**
 *
 * @author nmorla
 * @since Sep 12, 2020
 */
public class TruckTour {


    /*
     * Complete the truckTour function below.
     */
    static int truckTour(int[][] petrolpumps) {
        /*
         * Write your code here.
         */
        int nPetPumps = petrolpumps.length;
        int carryForwarded = 0;
        int index = 0;
        for (int i = 0; i < nPetPumps; i++) {
            int[] pair = petrolpumps[i];
            int petrol = pair[0];
            int distance = pair[1];
            int gap = petrol - distance;
            if ((carryForwarded + gap) < 0) {
                carryForwarded = 0;
                index = -1;
            } else {
                carryForwarded += gap;
                index = index == -1 ? i : index;
            }
        }
        return index;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[][] petrolpumps = new int[][]{{2, 3}, {3, 4}, {2, 2}, {5, 3}, {1, 5}, {3, 3}};

        int result = truckTour(petrolpumps);

        System.out.println("Start Position :: " + result);
    }
}
