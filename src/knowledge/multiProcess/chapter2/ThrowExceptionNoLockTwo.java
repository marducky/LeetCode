package knowledge.multiProcess.chapter2;

public class ThrowExceptionNoLockTwo extends Thread{
    private ThrowExceptionNoLock throwExceptionNoLock;
    public ThrowExceptionNoLockTwo(ThrowExceptionNoLock throwExceptionNoLock){
        super();
        this.throwExceptionNoLock=throwExceptionNoLock;
    }
    @Override
    public void run(){
        throwExceptionNoLock.exceptionMethod();
    }
}
