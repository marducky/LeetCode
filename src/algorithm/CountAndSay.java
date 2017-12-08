/**
 *
 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221
 */
package algorithm;

public class CountAndSay {
    public static String countAndSay(int n) {
        String resString=new String();
        resString=reIntN(n);

        return resString;

    }
    public static String reIntN(int n){
        if (n==1){
            return "1";
        }
        else return reIntN(n-1);
    }
    public static String reStr(int n){
        return "1";
    }
    public static void main(String[] args){
        System.out.println(countAndSay(4));
    }
}
