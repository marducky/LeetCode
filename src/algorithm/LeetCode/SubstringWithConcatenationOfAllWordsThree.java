/**
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 */
package algorithm.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWordsThree {
    public static List<Integer> findSubstring(String S, String[] L) {
        List<Integer> ans = new ArrayList<Integer>();
        if (S.length() < 1 || L.length < 1) return ans;
        int len = L[0].length(); //题目说L中每个单词长度一样

        //初始化HashMap，注意L中可能包含多个相同的字符串，所以用value表示个数
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int j = 0; j < L.length; j++) {
            if (map.containsKey(L[j])) {
                map.put(L[j], map.get(L[j]) + 1);
            } else {
                map.put(L[j], 1);
            }
        }

        //i的范围很关键，如果直接到S.length()是会超时的
        for (int i = 0; i <= S.length() - L.length * len; i++) {
            int from = i;
            String str = S.substring(from, from + len);
            int cnt = 0;
            while (map.containsKey(str) && map.get(str) > 0) {
                map.put(str, map.get(str) - 1);
                cnt++;
                from += len;
                if (from + len > S.length()) break; //注意越界
                str = S.substring(from, from + len);
            }

            //L中每个单词恰好出现一次，加入到结果集
            if (cnt == L.length) {
                ans.add(i);
            }

            //为下一次初始化HashMap
            if (cnt > 0) {
                map.clear();
                for (int j = 0; j < L.length; j++) {
                    if (map.containsKey(L[j])) {
                        map.put(L[j], map.get(L[j]) + 1);
                    } else {
                        map.put(L[j], 1);
                    }
                }
            }
        }

        return ans;
    }
    public static void main(String[] args){
        String s="eNqNzrEKwkAMBuB3ymaketakewakelakeVxKW9Shs4vgpG4iJVxTDFxwakelakemaketakezcnd1Kbf5FOoziC8lfQ1blakemakewaketakexc3hIEMgP9%2BfHpw23kHZg%2BiuUhqd44YVejaSLk2LLNPRc0uV89ieoMzneVZki3HyWZHAGXVHUMLOjlkHIflaketakemakewakeknrcSTTFsktiW06vjDph%2BrmjyydunafM0NNWRJFKUKxcjYpOPwPdTkPMtHgUNch2ZPNrYBhttjuF5e9yeEEN4doXxW";
        String s1="maketakewakelake";
        String[] ss={"lake","make","take","wake"};
        System.out.println(findSubstring(s,ss));
    }
}
