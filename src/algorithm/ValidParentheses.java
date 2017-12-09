package algorithm;

import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s){
        Stack<Character> stack=new Stack<Character>();
        stack.push(s.charAt(0));
        for (int i=1;i<s.length();i++){
            if (!stack.empty()&&(isMatch(stack.peek(),s.charAt(i))))
                stack.pop();
            else
                stack.push(s.charAt(i));
        }
        return stack.empty();
    }
    public static boolean isMatch(char a,char b){
        if ((a=='('&&b==')')||(a=='['&&b==']')||(a=='{'&&b=='}'))
            return true;
        else
            return false;

    }
    public static void main(String[] args){
        System.out.println(isValid("()(){}[()()"));
    }
}
