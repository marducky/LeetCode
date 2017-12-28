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
package algorithm;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        ArrayList<StringBuilder> stringBuilderArrayList=new ArrayList<StringBuilder>();
        List<Integer> integerList=new ArrayList<Integer>();
        stringBuilderArrayList=changeToStrings(n);
        for (StringBuilder stringBuilder:stringBuilderArrayList){
            integerList.add(sTringBufferToInt(stringBuilder));
        }

        return integerList;
    }
    public ArrayList<StringBuilder> changeToStrings(int n){
        ArrayList<StringBuilder> stringList=new ArrayList<StringBuilder>();
        ArrayList<StringBuilder> temArrayList=new ArrayList<StringBuilder>();
        if (n==0)
            return stringList;
        temArrayList=changeToStrings(n-1);
        for (StringBuilder tempString:temArrayList){
            StringBuilder zeroString=tempString.append("0");
            stringList.add(zeroString);

        }
        for (StringBuilder tempString:temArrayList){
            StringBuilder oneString=tempString.append("1");
            stringList.add(oneString);
        }
        return stringList;
    }
    public int sTringBufferToInt(StringBuilder stringBuilder){
//        stringBuilder.toString().length();
        int twoFor=1;
        int resInt=0;
        for (int i=stringBuilder.length()-1;i>=0;i--){
            resInt+=Integer.valueOf(stringBuilder.charAt(i))*twoFor;
            twoFor*=2;
        }
        return resInt;
    }
}
