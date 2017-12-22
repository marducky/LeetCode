package knowledge.multiProcess.chapter2;

public class PublicVarDirtyReadOne extends Thread{
    private PublicVarDirtyRead publicVarDirtyRead=new PublicVarDirtyRead();
    public PublicVarDirtyReadOne(PublicVarDirtyRead publicVarDirtyRead){
        super();
        this.publicVarDirtyRead=publicVarDirtyRead;
    }
    @Override
    public void run(){
        super.run();
        publicVarDirtyRead.setValue("B","BB");
    }
}
