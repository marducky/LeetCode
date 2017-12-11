package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesesTwo {
    public static boolean isValidTwo(String s){
        Stack<Character> stack=new Stack<Character>();
        Map<Character,Character> map=new HashMap<Character, Character>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        for (int i=0;i<s.length();i++){
            if (map.keySet().contains(s.charAt(i)))
                stack.push(s.charAt(i));
            else {
                if (!stack.empty()&&map.get(stack.peek())==s.charAt(i))
                    stack.pop();
                else
                    return false;
            }


        }
        return stack.empty();
    }
    public static void main(String[] args){
        System.out.println(isValidTwo("()(){}[()()"));
    }
}
