package algorithm.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonPrefix {
    public static String findFront(String[] strs) {
//        String resultStr="";
//        int tLne=tatalStr.length;
//        int minLne=0;
//        Map<Integer,Character> map=new HashMap<Integer, Character>();
//        map.put(0,tatalStr[0].charAt(0));
//        for (int i=0;i<tLne;i++){
//            minLne=Math.min(tatalStr[i].length(),minLne);
//        }
////        boolean flg=true;
//        for (int i=0;i<tLne;i++){
//            for (int j=0;j<minLne;j++){
//                if (!map.containsValue()
//                break;
//            }
//        }
//        return resultStr;
//
//    }
        if (strs.length == 0 || strs == null)
            return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char x = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() == i || strs[j].charAt(i) != x)
                    return strs[0].substring(0, i);
            }
        }

        return strs[0];
    }
    public static void main(String[] args){
        String[] strings={"qweert","qwefsf","qwefghh","qwejhkh","qwhkh"};
        System.out.println(findFront(strings));
    }
}