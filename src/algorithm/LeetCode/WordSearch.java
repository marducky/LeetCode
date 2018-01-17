/**
 * For example,
 Given board =
 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.
 */
package algorithm.LeetCode;

import java.util.ArrayList;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        return false;
        //TODO: this solution has much problem. so I decide to use the set to do this problem.
    }
    public boolean existPerChar(char[][] board, String word,int k){
        ArrayList<String> kArrayList=new ArrayList<String>();
        ArrayList<String> kPlusOneArrayList=new ArrayList<String>();
        kArrayList=findLocation(board,word.charAt(k));
        kPlusOneArrayList=findLocation(board,word.charAt(k+1));
        if (kArrayList.isEmpty()||kPlusOneArrayList.isEmpty())
            return false;
        if (k==word.length()-1)
            return true;
        for (int i=0;i<kArrayList.size();i++){
            for (int j=0;j<kPlusOneArrayList.size();j++){
                if ((kArrayList.get(i).charAt(0)!=kPlusOneArrayList.get(j).charAt(0))&&(kArrayList.get(i).charAt(1)!=kPlusOneArrayList.get(j).charAt(1)))
                    return false;
            }
        return true;
        }
        return false;
    }
    public ArrayList<String> findLocation(char[][] giveChar,char givePerChar){
        ArrayList<String> arrayList=new ArrayList<String>();
        int hLen=giveChar.length;
        int sLen=giveChar[0].length;
        for (int i=0;i<hLen;i++){
            for (int j=0;j<sLen;j++){
                if (giveChar[i][j]==givePerChar)
                    arrayList.add(i+j+"");
            }
        }
        return arrayList;
    }
}
