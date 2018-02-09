package knowledge.baseKnowledge.javaInherit;

public class ProtectInhiritParent {
    private String name;
    private int age;
    private String sex;

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "this name is" + name;
    }
}
