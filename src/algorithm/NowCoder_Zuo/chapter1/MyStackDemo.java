package algorithm.NowCoder_Zuo.chapter1;

import java.util.ArrayList;


public class MyStackDemo<T> {
    ArrayList<T> arrayList = new ArrayList<T>();
    private int size;
    private int aLength = arrayList.size();

    //    T tNull=null;
    public void push(T t) {
        arrayList.add(t);
    }

    public T peek() {
        return arrayList.get(arrayList.size() - 1);
    }

    public void pop() {
        arrayList.remove(arrayList.size() - 1);
//        arrayList.lastIndexOf()
    }

    public T min() {
        T t = arrayList.get(0);
        for (int i = 1; i < aLength; i++) {
            if (arrayList.get(i) == t) {

            }
        }
        return t;
    }

}
