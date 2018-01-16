package knowledge.baseKnowledge.garbageCollect;

//import org.python.antlr.ast.Str;

class gcTest{
    private String name;
    private  int age;
    public gcTest(String name){
        System.out.println("name : "+ name+" , age: "+" 0 ");
    }
    public gcTest(String name,int age){
        this.age=age;
        this.name=name;
        System.out.println("name : "+ name+" , age: "+age);
    }
    public gcTest(){
        System.out.println("name : "+" null"+" , age; "+" 0 ");
    }
}
public class gcTestDemo {

    public static void main(String[] args){
        gcTest gcTest=new gcTest();
        int a=1;
        int aaa=1;
        System.gc();
        String aa="22";
        String aaaaaaa="22"+aaa;
        System.gc();
//        System.gc();
    }
}
