/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.

 Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

 For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

 00 - 0
 01 - 1
 11 - 3
 10 - 2
 Note:
 For a given n, a gray code sequence is not uniquely defined.

 For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

 For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 */
package algorithm.LeetCode;

import java.util.ArrayList;

public class GrayCodeTwo {
    public ArrayList<Integer> grayCode(int n) {
        if(n==0) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(0);
            return result;
        }

        ArrayList<Integer> result = grayCode(n-1);
        int addNumber = 1 << (n-1);
        int originalsize=result.size();

        for(int i=originalsize-1;i>=0;i--) {
            result.add(addNumber + result.get(i));
        }
        return result;
    }
    public static void main(String[] args){
        GrayCodeTwo grayCodeTwo=new GrayCodeTwo();
        ArrayList<Integer> integerArrayList=new ArrayList<Integer>();
        integerArrayList=grayCodeTwo.grayCode(3);
        System.out.println(integerArrayList);
        System.gc();
    }
}
