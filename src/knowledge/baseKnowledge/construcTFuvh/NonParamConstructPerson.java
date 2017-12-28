package knowledge.baseKnowledge.construcTFuvh;

public class NonParamConstructPerson {
    String name;
    String age;
    NonParamConstructPerson(String name, String age){
        this.age=age;
        this.name=name;
    }
    NonParamConstructPerson(){}
    public static void main(String[] args){
        NonParamConstructPerson constructPerson=new NonParamConstructPerson("janus","24");
        NonParamConstructPerson nonParamConstructPerson=new NonParamConstructPerson();
        System.out.println(constructPerson.name+" : "+constructPerson.age);
        System.out.println(nonParamConstructPerson.name+" : "+nonParamConstructPerson.age);
    }
}
