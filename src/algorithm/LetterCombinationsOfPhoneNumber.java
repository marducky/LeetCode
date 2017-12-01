/**
 * 0:null,2:abc,3:def,4:ghi,5:jkl,6:mno,7:pqrs,8:tuv,9:wxyz
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
package algorithm;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if (digits==null||digits.length()==0)
            return null;
        int dLen=digits.length();
//        String[] string=digits.split("");

        for (int i=0;i<digits.length();i++){
            if (digits.charAt(i)==0||digits.charAt(i)==1)
                return null;
        }
        List<String> stringList=new ArrayList<String>();
        String[] strings={"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        for (int i=0;i<digits.length();i++){
            int charLen=strings[Integer.valueOf(digits.charAt(i))].length();
            for (int j=0;j<charLen;j++){
                String ssss="";
                ssss+=strings[Integer.valueOf(digits.charAt(i))].charAt(j);
            }

        }



        return stringList;
    }
}
