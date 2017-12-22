package knowledge.multiProcess.chapter2;

public class ThrowExceptionNoLockOne extends Thread{
    private ThrowExceptionNoLock throwExceptionNoLock;
    public ThrowExceptionNoLockOne(ThrowExceptionNoLock throwExceptionNoLock){
        super();
        this.throwExceptionNoLock=throwExceptionNoLock;
    }
    @Override
    public void run(){
        throwExceptionNoLock.exceptionMethod();
    }
}
