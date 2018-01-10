package knowledge.multiProcess.chapter6;

public class DCLForSafeSingleton {
    private volatile static DCLForSafeSingleton dclForSafeSingleton;

    private DCLForSafeSingleton() {
    }

    public static DCLForSafeSingleton getInstance() {
        try {
            if (dclForSafeSingleton != null) {

            } else {
                Thread.sleep(3000);
                synchronized (DCLForSafeSingleton.class) {
                    if (dclForSafeSingleton == null) {
                        dclForSafeSingleton = new DCLForSafeSingleton();
                    }
                }

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return dclForSafeSingleton;
    }
}
