package algorithm;

import java.util.HashMap;
import java.util.StringJoiner;
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s){
        HashMap<Integer,Character> map=new HashMap<Integer, Character>();
        map.put(0,s.charAt(0));
        for (int i=0;i<s.length();i++){
            if (map.containsValue(s.charAt(i)))
                map.put(i,s.charAt(i));
        }
        return map.size();
    }
    public static void main(String[] agrs){
        String s=new String();
        s="qwertyuiqeopshjkcshgh";
        int ss=lengthOfLongestSubstring(s);
        System.out.println(ss);
    }
}
