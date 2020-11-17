package dsalg;

import java.util.HashMap;
import java.util.Map;

/**
 * Leader means the element which appears more than n/2 ties where n is length of array.
 * @author nmorla
 * @since Nov 17, 2020
 */
public class LeaderInArray {

    public static void main(String[] args) {
        int[] a = {2, 3, 4, 3, 6, 0, 2, 3, 4, 5, 2, 3, 3, 3, 3};
        Map<Integer, Integer> map = new HashMap<>();
        int leaderCnt = 1 + a.length / 2;
        int maxCnt = 0;
        int leader = 0;
        for (int val : a) {
            Integer cnt = map.get(val);
            if (cnt == null) {
                cnt = 1;
            } else {
                cnt++;
            }
            map.put(val, cnt);
            if (maxCnt < cnt) {
                maxCnt = cnt;
                leader = val;
            }
        }
        if (maxCnt >= leaderCnt) {
            System.out.println("Leader :: " + leader);
        } else {
            System.out.println("No Leader");
        }
    }

}
