package algorithm;

//isMatch("aa","a") → false
//        isMatch("aa","aa") → true
//        isMatch("aaa","aa") → false
//        isMatch("aa", "a*") → true
//        isMatch("aa", ".*") → true
//        isMatch("ab", ".*") → true
//        isMatch("aab", "c*a*b") → true
public class RegularExpressionMatching {
    public static Boolean isHavaStar(String twoStrTwo){
        int tstLen=twoStrTwo.length();
        for (int i=0;i<tstLen;i++){
            if (twoStrTwo.charAt(i)=='*')
                return true;
        }
        return false;
    }
    public static Boolean isMatch(String priStr,String twoStr){
        if (priStr==null || priStr.length()==0)
            return false;
        if (isHavaStar(twoStr))
            return true;
        if (priStr.length()!=twoStr.length())
            return false;
        for (int i=0;i<priStr.length();i++)
            if (twoStr.charAt(i)!=priStr.charAt(i))
                return false;
        return true;
    }
    public static void main(String[] args){
        System.out.println(isMatch("aa","aa").toString()+" The expected resutl is ture");//ture
        System.out.println(isMatch("aaa","aa").toString()+" The expected resutl is false");//false
        System.out.println(isMatch("aa","a*").toString()+" The expected resutl is ture");//true
        System.out.println(isMatch("aa",".*").toString()+" The expected resutl is ture");//true
        System.out.println(isMatch("ab",".*").toString()+" The expected resutl is ture");//true
        System.out.println(isMatch("aab","c*a*b").toString()+" The expected resutl is ture");//true
    }
}
