/**
 *
 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221
 */
package algorithm.LeetCode;

public class CountAndSayTwo {
    public static String countAndSay(int n) {
        if(n<=0)
            return "";
        String curRes = "1";
        int start = 1;//从1开始算
        while(start < n){
            StringBuilder res = new StringBuilder();
            int count = 1;
            for(int j=1;j<curRes.length();j++){
                if(curRes.charAt(j)==curRes.charAt(j-1))
                    count++;
                else{
                    res.append(count);
                    res.append(curRes.charAt(j-1));
                    count = 1;
                }
            }
            res.append(count);
            res.append(curRes.charAt(curRes.length()-1));
            curRes = res.toString();
            start++;
        }
        return curRes;
    }
    public static void main(String[] args){
        System.out.println(countAndSay(17).length());
    }
}
