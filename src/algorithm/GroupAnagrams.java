/**
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:
 [
 ["ate", "eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 */
package algorithm;
import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> listList=new ArrayList<>();
        int strsLen=strs.length;
        ArrayList<Map<Character,Integer>> mapArrayList=new ArrayList<>();
        Map<Character,Integer> map=new HashMap<Character, Integer>();
//        map.put('a',1);
//        map.put('t',1);
//        map.put('e',1);
        for (int i=0;i<strsLen;i++){
            int perStrLen=strs[i].length();
            for (int j=0;j<perStrLen;j++){
                if (map.containsKey(strs[i].charAt(j))){
                    map.replace(strs[i].charAt(j),map.get(strs[i].charAt(j))+1);
                    continue;
                }
            }
            int temValue=map.get(strs[i].charAt(0));
            for (int k=0;k<perStrLen;k++){
                if (temValue!=map.get(strs[i].charAt(k))){
                    //TODO: use the map to deal the problem.
                }
            }
        }

        return listList;
        }
}
