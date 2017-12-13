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

public class GroupAnagramsThree {
    public List<List<String>> groupAnagramsTwo(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char [] str2char = s.toCharArray();
            Arrays.sort(str2char);
            String sortedStr = String.valueOf(str2char);
            if(map.containsKey(sortedStr)){
                map.get(sortedStr).add(s);
            }else{
                ArrayList<String> tmp = new ArrayList<String>();
                tmp.add(s);
                map.put(sortedStr, tmp);
            }
        }
        List<List<String>> result = new ArrayList<List<String>>();
        for (List<String> list : map.values()) {
            Collections.sort(list);
            result.add(list);
        }
        return result;
    }
    public static void main(String[] args){
        String[] giveStrings={"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] giveStrings2={ "tan", "ate","bat"};
        String[] giveStrings3={ "eat", "tea"};
//        GenerateParentsThiefsTwo generateParentsThiefsTwo=new GenerateParentsThiefsTwo();
        GroupAnagramsThree groupAnagramsTwo=new GroupAnagramsThree();
        System.out.println(groupAnagramsTwo.groupAnagramsTwo(giveStrings));
    }
}
