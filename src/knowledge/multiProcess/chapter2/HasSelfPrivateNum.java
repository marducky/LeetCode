package knowledge.multiProcess.chapter2;

//the function of the keys scope"
//public>protected>default>private
public class HasSelfPrivateNum {
    private int num=0;
    synchronized public void addI(String username){
        try {
//            int num=0;
            if (username.equals("a")){
                num=100;
                System.out.println("a set over!");
                Thread.sleep(2000);
            }else {
                num=200;
                System.out.println("b set over");
            }
            System.out.println(username+" num= "+num);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
