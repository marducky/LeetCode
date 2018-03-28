package algorithm.LintCode;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/03/28 15:17
 **/

import java.util.ArrayList;
import java.util.Arrays;

/**
 * if n = 12, k = 1 in
 * <p>
 * [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
 * we have FIVE 1's (1, 10, 11, 12)
 */
public class M3_DigitCounts {
    public int digitCounts(int k, int n) {
        // write your code here
        if (k <= 0 || n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
//        int res=0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i <= k; i++) {

            if ((i + "").indexOf(n + "") != -1) {
                arrayList.add(i);
            }
        }
        System.out.println(Arrays.asList(arrayList) + " have " + (arrayList.toString().length() - arrayList.toString().replace(n + "", "").length()) + " n ( n = " + n + " )");
        return arrayList.size();
    }
}
