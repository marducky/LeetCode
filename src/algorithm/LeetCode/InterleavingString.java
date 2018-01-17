/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * <p>
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * <p>
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 */
package algorithm.LeetCode;

import java.util.Stack;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        Stack<Character> stackS1 = pushToStack(s1);
        Stack<Character> stackS2 = pushToStack(s2);
        Stack<Character> stackS3 = pushToStack(s3);
        if (stackS1.empty() && stackS2.empty() && stackS3.empty())
            return true;
        while (!stackS3.empty() && !stackS1.empty() && !stackS3.empty()) {
            if ((stackS1.peek() == stackS3.peek()) && ((stackS2.peek() == stackS3.peek()))) {
                String tempS1Begin = s1.substring(stackS1.size(), s1.length());
                String tempS2End = s2.substring(stackS2.size() + 1, s2.length());
                String tempS2Begin = s2.substring(stackS2.size(), s2.length());
                String tempS1End = s1.substring(stackS1.size() + 1, s1.length());
                String tempS3ALL = s3.substring(stackS2.size() + 1 + stackS1.size(), s3.length());
                if (isInterleave(tempS1Begin, tempS2End, tempS3ALL) && isInterleave(tempS2Begin, tempS1End, tempS3ALL))
                    return true;
            } else if (stackS3.peek() == stackS1.peek()) {
                stackS1.pop();
                stackS3.pop();
            } else {
                stackS2.pop();
                stackS3.pop();
            }
        }
        if (!stackS3.empty() && !stackS1.empty() && !stackS3.empty())
            return true;
        return false;
    }

    public Stack<Character> pushToStack(String demoString) {
        Stack<Character> stringStack = new Stack<Character>();
        for (int i = 0; i < demoString.length(); i++) {
            stringStack.push(demoString.charAt(i));
        }
        return stringStack;
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";

        String s3 = "aadbbcbcac";
        String s31 = "aadbbbaccc";
        InterleavingString interleavingString = new InterleavingString();
        System.out.println(interleavingString.isInterleave(s1, s2, s3));

    }
}
