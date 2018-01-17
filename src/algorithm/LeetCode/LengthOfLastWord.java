package algorithm.LeetCode;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s.charAt(s.length()-1)==' '){
            return 0;
        }
        String[] resStr=s.split(" ");
        return resStr[resStr.length-1].length();
    }
    public static void main(String[] args){
        String giveStr="hello world";
        String giveStr1="hello world ";
        LengthOfLastWord lengthOfLastWord=new LengthOfLastWord();
        System.out.println(lengthOfLastWord.lengthOfLastWord(giveStr));
        System.out.println(lengthOfLastWord.lengthOfLastWord(giveStr1));
    }
}
