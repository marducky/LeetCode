package knowledge.multiProcess.chapter3;

import java.util.ArrayList;
import java.util.List;

public class ThreadLocalActionListDemo extends ThreadLocal<List<String>> {
    List<String> tudouList = new ArrayList<String>();

    @Override
    public List<String> initialValue() {
        tudouList.add("a");
        tudouList.add("b");
        System.out.println("List size :" + tudouList.size());
        return tudouList;
    }

    public static void main(String[] args) {

        ThreadLocalActionListDemo local = new ThreadLocalActionListDemo();

        new Thread(new ListThread(local)).start();
        new Thread(new ListThread(local)).start();
        //可以看到，传递引用类型的话，还是会改变引用的值的。
        //Thread-2: final [a, b, Thread-0, a, b, Thread-1, a, b, Thread-2]
        //
        new Thread(new ListThread(local)).start();
    }
}
