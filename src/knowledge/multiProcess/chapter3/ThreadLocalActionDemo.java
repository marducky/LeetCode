package knowledge.multiProcess.chapter3;

public class ThreadLocalActionDemo extends ThreadLocal<Long> {
    Long value = new Long(1);

    @Override
    public Long initialValue() {
        return new Long(1);

    }

    public static void main(String[] args) {
        ThreadLocalActionDemo threadLocalActionDemo = new ThreadLocalActionDemo();
        new Thread(new ThreadLocalActionDemoLongThread(threadLocalActionDemo, new Long(2))).start();
        new Thread(new ThreadLocalActionDemoLongThread(threadLocalActionDemo, new Long(5))).start();
        new Thread(new ThreadLocalActionDemoLongThread(threadLocalActionDemo, new Long(8))).start();
    }
}
