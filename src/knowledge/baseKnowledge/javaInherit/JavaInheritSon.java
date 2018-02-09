package knowledge.baseKnowledge.javaInherit;

public class JavaInheritSon extends JavaInheritParent {
    private JavaWife javaWife;

    JavaInheritSon() {
        super("qmz");
        System.out.println("Son construct!");
    }

    public static void main(String[] args) {
        //main method
        JavaInheritSon javaInheritSon = new JavaInheritSon();
    }
}
