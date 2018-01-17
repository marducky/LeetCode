/**
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:
 [
 ["ate", "eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 */
package algorithm.LeetCode;

import java.util.*;

public class GroupAnagramsFour {
    public List<List<String>> groupAnagramsTwo(String[] strs) {
        Map<String,ArrayList<String>> stringArrayListMap=new HashMap<String, ArrayList<String>>();
        for (String tempStr:strs){
            char[] chars= tempStr.toCharArray();
            Arrays.sort(chars);
            String sorterStr=Arrays.toString(chars);
            if (stringArrayListMap.containsKey(sorterStr)){
                stringArrayListMap.get(sorterStr).add(tempStr);
            }
            else {
                ArrayList<String> tmpList = new ArrayList<String>();
                tmpList.add(tempStr);
                stringArrayListMap.put(sorterStr,tmpList);
            }
        }
        List<List<String>> result = new ArrayList<List<String>>();
        for (List<String> list : stringArrayListMap.values()) {
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
        GroupAnagramsFour groupAnagramsTwo=new GroupAnagramsFour();
        System.out.println(groupAnagramsTwo.groupAnagramsTwo(giveStrings));
    }
}
