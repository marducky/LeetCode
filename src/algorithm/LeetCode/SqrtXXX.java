/**
 * Example 1:

 Input: 4
 Output: 2
 Example 2:

 Input: 8
 Output: 2
 Explanation: The square root of 8 is 2.82842..., and since we want to return an integer, the decimal part will be truncated.
 */
package algorithm.LeetCode;

public class SqrtXXX {
    public int mySqrt(int x) {
        if ( x==0)
            return 0;
        for (int i=1;i<x;i++){
            if (i*i>x)
                return i-1;
        }
        return 0;
    }
    public static void main(String[] args){
        SqrtXXX sqrtXXX=new SqrtXXX();
        System.out.print(sqrtXXX.mySqrt(27));
    }
}
