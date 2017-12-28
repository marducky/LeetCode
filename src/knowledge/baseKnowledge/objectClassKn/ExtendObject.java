package knowledge.baseKnowledge.objectClassKn;

public class ExtendObject extends Object{
    private String name;
    public ExtendObject(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public static void main(String[] args){
        ExtendObject extendObject=new ExtendObject("janus");
        System.out.println(extendObject.getName());
    }
}
