package dsalg;

/**
 *
 * @author nmorla
 * @since Oct 13, 2020
 */
public class RemoveDuplicates2Pointers {

    public static void main(String[] args) {
        int[] input = {8, 8, 8, 8, 8, 8, 8};
        int unique = getUnique(input);
        for (int i = 0; i <= unique; i++) {
            System.out.print(" " + input[i]);
        }
        System.out.println("");
    }

//    1800*10;
//    5500;
//    8885 8181 74;
    private static int getUnique(int[] inputs) {
        if (inputs.length <= 1) {
            return inputs.length;
        }
        int p1 = 0, p2 = 1;
        while (p2 < inputs.length) {
            if (inputs[p1] != inputs[p2] && (p2 - p1) == 1) {
                p1++;
                p2++;
            } else if (inputs[p1] != inputs[p2] && (p2 - p1) > 1) {
                inputs[p1 + 1] = inputs[p2];
                p1++;
                p2++;
            } else {
                p2++;
            }
        }
        return p1;
    }
}
