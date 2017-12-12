package knowledge.DesignPattern.SingletonPattern;

public class DoubleCheckedLockingSingleObject {
    private volatile static DoubleCheckedLockingSingleObject doubleCheckedLockingSingleObject;
    private DoubleCheckedLockingSingleObject(){}

    public  static DoubleCheckedLockingSingleObject getDoubleCheckedLockingSingleObject() {
        if (doubleCheckedLockingSingleObject==null)
            synchronized (DoubleCheckedLockingSingleObject.class){
            if (doubleCheckedLockingSingleObject==null){
                doubleCheckedLockingSingleObject=new DoubleCheckedLockingSingleObject();
            }

            }
        return doubleCheckedLockingSingleObject;
    }
}
