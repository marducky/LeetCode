/**
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 */
package algorithm.LeetCode;

import java.util.*;

public class SubstringWithConcatenationOfAllWordsTwo {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> resultList=new ArrayList<Integer>();
        int wLen=words.length;//the count of words.
        int pLen=words[0].length();//the length of per word.
        s=s.trim();
        int sLen=s.length();
        Map<Integer,String> map=new HashMap<Integer, String>();
        for (int i=0;i<wLen;i++){
            map.put(i,words[i]);
        }
        for (int i=0;i<=sLen-wLen*pLen;i++){
            Map<Integer,String> mapTemp=map;
            int count=0;
            int iFlag=i;
            System.out.print(mapTemp.isEmpty());
            while (!mapTemp.isEmpty()){
                System.out.print(s.substring(iFlag,iFlag+pLen));
                if (mapTemp.containsValue(s.substring(iFlag,iFlag+pLen))){
                    mapTemp.remove(s.substring(iFlag,iFlag+pLen));
                    System.out.print(mapTemp);
                    iFlag=iFlag+3;
                    count++;
                }
            }
            if (count==6)
                resultList.add(i);
            i=i+3;
        }
        return resultList;

    }
    public static void main(String[] args){
//        String s="eNqNzrEKwkAMBuB3ymaketakewakelakeVxKW9Shs4vgpG4iJVxTDFxwakelakemaketakezcnd1Kbf5FOoziC8lfQ1blakemakewaketakexc3hIEMgP9%2BfHpw23kHZg%2BiuUhqd44YVejaSLk2LLNPRc0uV89ieoMzneVZki3HyWZHAGXVHUMLOjlkHIflaketakemakewakeknrcSTTFsktiW06vjDph%2BrmjyydunafM0NNWRJFKUKxcjYpOPwPdTkPMtHgUNch2ZPNrYBhttjuF5e9yeEEN4doXxW";
        String s="maketakewakelake";
        String[] ss={"lake","make","take","wake"};
        System.out.println(findSubstring(s,ss));
    }
}
