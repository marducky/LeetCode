package knowledge.baseKnowledge.construcTFuvh;

public class ConstructPerson {
    String name;
    String age;
    ConstructPerson(String name,String age){
        this.age=age;
        this.name=name;
    }
    public static void main(String[] args){
        ConstructPerson constructPerson=new ConstructPerson("janus","24");
        System.out.println(constructPerson.name+" : "+constructPerson.age);
    }
}
