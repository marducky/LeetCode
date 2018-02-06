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

public class GroupAnagramsTwo {
    public List<List<String>> groupAnagramsTwo(String[] strs) {
        List<List<String>> listList=new ArrayList<>();
        List<List<String>> tempListList=new ArrayList<>();
        tempListList=listList;
        List<String> list=new ArrayList<>();
        for (int i=0;i<strs.length;i++){
            if (listList.isEmpty()){
                listList.add(Arrays.asList(strs[i]));
                continue;
            }
            List<String> temPerlist=new ArrayList<>();
            for (List<String> perList:tempListList){
                if (isSmapeSortStrs(perList.get(0),strs[i])){
//                    listList[listList.indexOf(perList)];
//                    temPerlist=perList;
//                    temPerlist.add(strs[i]);
                }
                //https://www.cnblogs.com/andy-zhou/p/5339683.html
                //to solve the :javaInherit.util.ConcurrentModificationException
                //在前面一篇文章中提到，对Vector、ArrayList在迭代的时候如果同时对其进行修改就会抛出java.util.ConcurrentModificationException异常。
//                if (isSmapeSortStrs(perList.get(0),strs[i]))
////                    List<String> tempPerList=perList;
//                    perList.add(strs[i]);
//                else {
////                    List<String> list=new ArrayList<String>();
////                    list.add(strs[i]);
////                    listList.add(list);
//                    listList.add(Arrays.asList(strs[i]));
//                }

//                for (int k=0;k<perList.get(0).length();k++) {
//                    for (int j = 0; j < strs[i].length(); j++) {
//                        if ((strs[i].charAt(j)!=perList.get(0).charAt(k))&&(strs[i].length()!=perList.get(0).length())){
//                            break;
//                        }
//                    }
//
//                }
            }
        }
        return listList;
    }
    public boolean isSmapeSortStrs(String string1,String string2){
        if (string1.length()!=string2.length())
            return false;
        for (int i=0;i<string1.length();i++){
            for (int j=0;j<string2.length();j++){
                if (string1.charAt(i)!=string2.charAt(j)){
                    return false;
                }
            }
        }
            return true;
    }
    public static void main(String[] args){
        String[] giveStrings={"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] giveStrings2={ "tan", "ate","bat"};
        String[] giveStrings3={ "eat", "tea"};
//        GenerateParentsThiefsTwo generateParentsThiefsTwo=new GenerateParentsThiefsTwo();
        GroupAnagramsTwo groupAnagramsTwo=new GroupAnagramsTwo();
        System.out.println(groupAnagramsTwo.groupAnagramsTwo(giveStrings3));
    }
}
