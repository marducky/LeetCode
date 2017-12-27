package knowledge.multiProcess.chapter2;

public class MainMian {

    //
    public static void main(String[] args){
//        //HasSelfPRivateNum
//        HasSelfPrivateNum numRef=new HasSelfPrivateNum();
//        HasSelfPrivateNumOne hasSelfPrivateNumOne=new HasSelfPrivateNumOne(numRef);
//        hasSelfPrivateNumOne.start();
//        HasSelfPrivateNumTwo hasSelfPrivateNumTwo=new HasSelfPrivateNumTwo(numRef);
//        hasSelfPrivateNumTwo.start();
        //PublicVarDirtyRead
//        try {
//            PublicVarDirtyRead publicVarDirtyRead=new PublicVarDirtyRead();
//            PublicVarDirtyReadOne publicVarDirtyReadOne=new PublicVarDirtyReadOne(publicVarDirtyRead);
//            publicVarDirtyReadOne.start();
//            Thread.sleep(200);
//            publicVarDirtyRead.getValue();
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
        //SynchronizedLockReloadOne main
//        SynchronizedLockReloadOne t=new SynchronizedLockReloadOne();
//        t.start();
//        try {
//            ThrowExceptionNoLock throwExceptionNoLock=new ThrowExceptionNoLock();
//            ThrowExceptionNoLockOne one=new ThrowExceptionNoLockOne(throwExceptionNoLock);
//            one.setName("a");
//            one.start();
//            Thread.sleep(500);
//            ThrowExceptionNoLockTwo two=new ThrowExceptionNoLockTwo(throwExceptionNoLock);
//            two.setName("b");
//            two.start();
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
        SynchronizedCycleForFor synchronizedCycleForFor=new SynchronizedCycleForFor();
        SynchronizedCycleForForOne synchronizedCycleForForOne=new SynchronizedCycleForForOne(synchronizedCycleForFor);
        synchronizedCycleForForOne.start();
        SynchronizedCycleForForTwo synchronizedCycleForForTwo=new SynchronizedCycleForForTwo(synchronizedCycleForFor);
        synchronizedCycleForForTwo.start();
    }
}
