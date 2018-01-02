package knowledge.baseKnowledge.objectClassKn.toString;

public class ToStringDemo {
    private String name;
    private int age;
    public ToStringDemo(String name,int age){
        this.age=age;
        this.name=name;
    }
    @Override
    public String toString(){
        return name+": "+age;
    }
    public static void main(String[] args){
        ToStringDemo  toStringDemo=new ToStringDemo("Janus",25);
        System.out.println(toStringDemo.toString());
    }
}
