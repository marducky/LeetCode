package knowledge.baseKnowledge;
class Base{
    public Base(){
        System.out.println("This is the base con fun. "+Thread.currentThread().getName());
    }
}
public class CheckSuper extends Base{
    public CheckSuper(){
        super();
        System.out.print("This is the son fun. "+Thread.currentThread().getName());

    }
    public static void main(String[] args){
        CheckSuper checkSuper=new CheckSuper();

    }
}
