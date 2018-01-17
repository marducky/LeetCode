package algorithm.NowCoder_Zuo.chapter1;

import java.util.Stack;

public class StackImplDqueue {
    private static Stack<Integer> stack1 = new Stack<Integer>();
    private static Stack<Integer> stack2 = new Stack<Integer>();
    private static int peek = 0;


    public void add(Integer integer) {
        stack1.push(integer);
        stack2.clear();
        for (int temp = stack1.size() - 1; temp >= 0; temp--) {
            stack2.push(stack1.get(temp));
        }
        peek = stack2.peek();
    }

    public int poll() {
        int t = stack1.peek();
        stack2.pop();
        stack1.clear();
//        for (int temp:stack2){
//            stack1.push(temp);
//        }
        for (int temp = stack2.size() - 1; temp >= 0; temp--) {
            stack1.push(stack2.get(temp));
        }
        peek = stack1.peek();
//        return stack2.peek();
        return t;
    }

    public int peek() {
        return peek;
    }

    public static void main(String[] args) {
        StackImplDqueue stackImplDqueue = new StackImplDqueue();
        stackImplDqueue.add(22);
        System.out.println(stackImplDqueue.peek());
        stackImplDqueue.add(21);
        System.out.println(stackImplDqueue.peek());
        stackImplDqueue.add(24);
        System.out.println(stackImplDqueue.peek());
        stackImplDqueue.add(25);
        System.out.println(stackImplDqueue.peek());


        System.out.println(stackImplDqueue.poll());
        System.out.println(stackImplDqueue.peek());
        System.out.println(stackImplDqueue.poll());
        System.out.println(stackImplDqueue.peek());

    }
}
