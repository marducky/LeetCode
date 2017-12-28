package knowledge.baseKnowledge.construcTFuvh;

class CodeScopeConstructPerson{
    private int id;

    private String name;

    private int age;

    {
        cry();// 每个Person对象创建出来都会执行这里的代码，构造代码块
    }

    public CodeScopeConstructPerson(){
        cry();
    }
    public CodeScopeConstructPerson(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
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


    public void cry(){
        System.out.println("哇哇哇....");
    }

}
