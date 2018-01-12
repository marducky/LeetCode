package knowledge.baseKnowledge.javaCollectionFramework;

import java.util.ArrayDeque;
import java.util.Stack;

public class StackArrayQueue {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i * i);
        }
        for (int i = 0; i < 10; i += 2) {
            arrayDeque.push(i * i * i);
        }
        System.out.println(stack);
        stack.peek();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        System.out.println(arrayDeque);
        arrayDeque.addFirst(123);
        System.out.println(arrayDeque);
        arrayDeque.addLast(321);
        System.out.println(arrayDeque);


    }
}
