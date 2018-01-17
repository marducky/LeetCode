/**
 * Example 1:

 Input: 2.00000, 10
 Output: 1024.00000
 Example 2:

 Input: 2.10000, 3
 Output: 9.26100
 */
package algorithm.LeetCode;

public class PowerXNTwo {
    public double power(double x, int n) {
        if (n == 0)
            return 1;

        double v = power(x, n / 2);

        if (n % 2 == 0) {
            return v * v;
        } else {
            return v * v * x;
        }
    }

    public double pow(double x, int n) {
        if (n < 0) {
            return 1 / power(x, -n);
        } else {
            return power(x, n);
        }
    }
    public static void main(String[] args){

        PowerXNTwo powerXN=new PowerXNTwo();
        System.out.println(powerXN.power(2.0000,3));
        System.out.print(powerXN.pow(2.0000,3));
    }
}
