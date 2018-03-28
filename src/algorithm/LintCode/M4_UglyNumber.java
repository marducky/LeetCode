package algorithm.LintCode;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/03/28 17:26
 **/

/**
 * Ugly number is a number that only have factors 2, 3 and 5.
 * Design an algorithm to find the nth ugly number. The first 10 ugly numbers are 1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
 */
public class M4_UglyNumber {
    public int nthUglyNumber(int n) {
        // write your code here
        int cout = 0;
        int i = 1;
        while (cout < n) {
            if (isUglyNumber(i)) {
                cout++;
            }
        }
        return i;
    }

    public boolean isUglyNumber(int n) {
        if (n == 1)
            return true;
        else {
            if (n % 2 == 0) {
                return isUglyNumber(n / 2);
            } else if (n % 3 == 0) {
                return isUglyNumber(n / 3);
            } else if (n % 5 == 0) {
                return isUglyNumber(nthUglyNumber(n / 5));
            } else {
                return false;
            }
        }
    }
}
