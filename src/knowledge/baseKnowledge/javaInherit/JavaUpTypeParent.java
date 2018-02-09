package knowledge.baseKnowledge.javaInherit;

public class JavaUpTypeParent {
    public void display() {
        System.out.println("Play Person...");
    }

    static void display(JavaUpTypeParent person) {
        person.display();
    }
}
