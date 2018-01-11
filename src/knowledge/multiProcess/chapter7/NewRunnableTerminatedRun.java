package knowledge.multiProcess.chapter7;

public class NewRunnableTerminatedRun {
    public static void main(String[] args) {
        try {
            NewRunnableTerminated terminated = new NewRunnableTerminated();
            System.out.println("main method state1: " + terminated.getState());
            terminated.setName("aaaaa");
            terminated.start();
            System.out.println("main method state2: " + terminated.getState());
            Thread.sleep(3000);
            System.out.println("main method state3: " + terminated.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
