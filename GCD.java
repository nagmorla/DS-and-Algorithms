package dsalg;

/**
 *
 * @author nmorla
 * @since Aug 22, 2020
 */
public class GCD {
    public static void main(String[] args) {
        System.out.println("---> "+getGcd(108, 54));
        System.out.println("---> "+getGcd(108, 45, 216));
    }
    
    static int getGcd(int a, int b) {
        if (a == b) {
            return a;
        }
        if (a == 1 || b == 1) {
            return 1;
        }
        if (a < b) {
            return getGcd(b - a, a);
        } else {
            return getGcd(a - b, a);
        }
    }
    
    
    static int getGcd(int a, int b, int c) {
        return getGcd(a, getGcd(b, c));
    }
}
