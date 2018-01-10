package knowledge.multiProcess.chapter6;

public class HungrySingleton {
    private static HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return hungrySingleton;
        //getInstance 沒有同步問題
        //此代碼為利基加載
        //此版本的缺點是不能有其他實例變量
    }
}
