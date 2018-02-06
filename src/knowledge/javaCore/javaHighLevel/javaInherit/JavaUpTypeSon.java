package knowledge.javaCore.javaHighLevel.javaInherit;

public class JavaUpTypeSon extends JavaUpTypeParent {
    public static void main(String[] args) {
        JavaUpTypeSon husband = new JavaUpTypeSon();
        JavaUpTypeParent.display(husband);      //向上转型
    }
}
