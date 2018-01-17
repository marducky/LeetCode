/**
 * 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Given an encoded message containing digits, determine the total number of ways to decode it.

 For example,
 Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

 The number of ways decoding "12" is 2.
 */
package algorithm.LeetCode;

public class DecodeWays {
    public int numDecodings(String s) {
        int resCount=0;
        for (int i=0;i<s.length()-1;i++){
            resCount+=returnCounTwoStr(s.charAt(i),s.charAt(i+1));
        }
        return resCount;
    }
    public int returnCounTwoStr(char first,char two){
        int perTwoCount=0;

//        if ((Integer.valueOf(first))>0&&(Integer.valueOf(first))<27){
//            perTwoCount+=1;
//        }
//        if ((Integer.valueOf(first)*10+Integer.valueOf(two))>0&&(Integer.valueOf(first)*10+Integer.valueOf(two))<27){
//            perTwoCount+=1;
//        }
        int firstInt=Character.getNumericValue(first);
        int twoInt=Character.getNumericValue(two);
        if (firstInt>0&&firstInt<27){
            perTwoCount++;
        }
        if ((firstInt*10+twoInt)>0&&(firstInt*10+twoInt)<27){
            perTwoCount++;
        }
        return perTwoCount;
    }
    public static void main(String[] args){
        DecodeWays decodeWays=new DecodeWays();
//        System.out.println((Integer.valueOf('0')));
//        System.out.println((Integer.valueOf('1')));
//        System.out.println('1'-'0');
//        System.out.println(decodeWays instanceof DecodeWays);
        String s="123897654212341238976542123412389765421234";
//        System.out.println(s.length());
        System.out.println(decodeWays.numDecodings(s));
    }
}
