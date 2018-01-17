package algorithm.NowCoder_Zuo.chapter1;

import java.util.ArrayList;

public class MyStackInteger {
    ArrayList<Integer> arrayList = new ArrayList<Integer>();
    private int aLength = arrayList.size();

    public void pop() {
        if (arrayList.isEmpty()) {

        } else {
            arrayList.remove(arrayList.size());
        }
    }

    public void push(int tTemp) {
        arrayList.add(tTemp);
    }

    public int peek() {
        return arrayList.get(arrayList.size() - 1);
    }

    public int size() {
        return arrayList.size();
    }

    public int min() {
        int tTemoo = arrayList.get(0);
        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i) < tTemoo) {
                tTemoo = arrayList.get(i);
            }
        }
        return tTemoo;
    }

    public static void main(String[] args) {
        MyStackInteger myStackInteger = new MyStackInteger();
        myStackInteger.push(1);
        myStackInteger.push(2);
        myStackInteger.push(3);
        myStackInteger.push(4);
        System.out.println(myStackInteger.peek());

    }
}
