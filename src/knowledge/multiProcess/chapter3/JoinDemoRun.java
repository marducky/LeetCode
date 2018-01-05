package knowledge.multiProcess.chapter3;

public class JoinDemoRun extends Thread {
    public static void main(String[] args) {
        try {
            JoinDemo joinDemo = new JoinDemo();

            joinDemo.start();
            joinDemo.join();
//        joinDemo.sleep(1000);
            StringBuffer stringBuffer = new StringBuffer("JoinDemo");
            System.out.println(stringBuffer.getClass().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.gc();
    }

}
