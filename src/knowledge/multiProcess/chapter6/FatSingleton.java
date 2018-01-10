package knowledge.multiProcess.chapter6;

public class FatSingleton {
    private static FatSingleton fatSingleton;

    private FatSingleton() {
    }

    public static FatSingleton getInstance() {
        if (fatSingleton != null) {
        } else {
            fatSingleton = new FatSingleton();
        }
        return fatSingleton;
    }
}
