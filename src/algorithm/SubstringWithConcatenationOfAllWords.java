/**
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 */
package algorithm;

import java.util.*;

public class SubstringWithConcatenationOfAllWords {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> resultList=new ArrayList<Integer>();
        int wLen=words.length;//the count of words.
        int pLen=words[0].length();//the length of per word.
        int sLen=s.length();
        Set<String> set=new HashSet<String>();
        for (int i=0;i<wLen;i++){
            set.add(words[i].trim());
        }
        int count=0;
        s=s.trim();
        for (int i=0;i<sLen-wLen*pLen;i++){
            if (set.contains(s.substring(i,i+pLen)))
            {
                System.out.print(s.substring(i,i+pLen));
                i=i+3;
                count++;
                resultList.add(i);

            }
        }
        return resultList;

    }
    public static void main(String[] args){
        String s="eNqNzrEKwkAMBuB3yVxKW9Shs4vgpG4iJVxTDFxzcnd1Kbf5FOoziC8lfQ1bxc3hIEMgP9%2BfHpw23kHZg%2BiuUhqd44YVejaSLk2LLNPRc0uV89ieoMzneVZki3HyWZHAGXVHUMLOjlkHIfknrcSTTFsktiW06vjDph%2BrmjyydunafM0NNWRJFKUKxcjYpOPwPdTkPMtHgUNch2ZPNrYBhttjuF5e9yeEEN4doXxW";
        String[] ss={"Bu","xc"};
        System.out.println(findSubstring(s,ss));
    }
}
