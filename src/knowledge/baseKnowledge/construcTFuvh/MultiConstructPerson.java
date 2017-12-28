package knowledge.baseKnowledge.construcTFuvh;

public class MultiConstructPerson {
    private String id;
    private String name;
    private int age;
    public MultiConstructPerson(){
        cry();
    }
    public MultiConstructPerson(String id,String name,int age){
        this.age=age;
        this.id=id;
        this.name=name;
        System.out.println("[String id,String name,int age] as Construct Function.");
    }
    private void cry(){
        System.out.println("No Param Construct Function, But hava other function");
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
