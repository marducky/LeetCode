/**
 * For example,
 words: ["This", "is", "an", "example", "of", "text", "justification."]
 L: 16.

 Return the formatted lines as:
 [
 "This    is    an",
 "example  of text",
 "justification.  "
 ]
 */
package algorithm.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> stringList=new ArrayList<String>();
        int[] lenStore=new int[words.length];
        for (int i=0;i<words.length;i++){
            lenStore[i]=words[i].length();
        }
        int sum=0;
        int start=0;
        for (int i=0;i<words.length;i++){
            if (lenStore[i]>16)
                return null;
            sum+=lenStore[i];
            if (sum>16){
                String tempString="";
                int acturlLen=sum-lenStore[i];
                int spaceLen=maxWidth-acturlLen;
                for (int j=start;j<i-start;j++){
                    tempString+=words[j];
                }
                for (int j=0;j<spaceLen;j++){
                    tempString+=" ";
                }
                stringList.add(tempString);
                start=i;
                sum=0;
            }
        }
        return stringList;
    }
    public static void main(String[] agrs){
        TextJustification textJustification=new TextJustification();
        String[] strings={"This", "is", "an", "example", "of", "text", "justification."};
        System.out.print(textJustification.fullJustify(strings,16));
    }
}
