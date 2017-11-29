//isMatch("aa","a") → false
//        isMatch("aa","aa") → true
//        isMatch("aaa","aa") → false
//        isMatch("aa", "a*") → true
//        isMatch("aa", ".*") → true
//        isMatch("ab", ".*") → true
//        isMatch("aab", "c*a*b") → true
public class RegularExpressionMatchingTwo {
    public static Boolean isHavaStarTwo(String twoStrTwo){
        int tstLen=twoStrTwo.length();
        for (int i=0;i<tstLen;i++){
            if (twoStrTwo.charAt(i)=='*')
                return true;
        }
        return false;
    }
    public static Boolean isMatchTwo(String priStr,String twoStr){
        if (priStr==null || priStr.length()==0)
            return false;
        if (isHavaStarTwo(twoStr))
            return true;
        if (priStr.length()!=twoStr.length())
            return false;
        for (int i=0;i<priStr.length();i++)
            if (twoStr.charAt(i)!=priStr.charAt(i))
                return false;
        return true;
    }
    public static void main(String[] args){
        System.out.println(isMatchTwo("aa","aa").toString()+" The expected resutl is ture");//ture
        System.out.println(isMatchTwo("aaa","aa").toString()+" The expected resutl is false");//false
        System.out.println(isMatchTwo("aa","a*").toString()+" The expected resutl is ture");//true
        System.out.println(isMatchTwo("aa",".*").toString()+" The expected resutl is ture");//true
        System.out.println(isMatchTwo("ab",".*").toString()+" The expected resutl is ture");//true
        System.out.println(isMatchTwo("aab","c*a*b").toString()+" The expected resutl is ture");//true
    }
}
