package knowledge.multiProcess.chapter2;

public class PublicVarDirtyRead {
    public String usename="A";
    public String password="AA";
    synchronized public void setValue(String usename,String password){
        try{
            this.usename=usename;
            Thread.sleep(5000);
            this.password=password;
            System.out.println("setValue method thread name= "+Thread.currentThread().getName()+" username= "+usename+" password= "+password);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    synchronized public void getValue(){
        System.out.println("setValue method thread name= "+Thread.currentThread().getName()+" username= "+usename+" password= "+password);
    }
}
