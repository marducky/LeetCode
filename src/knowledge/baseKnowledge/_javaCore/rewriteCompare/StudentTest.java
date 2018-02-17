package knowledge.baseKnowledge._javaCore.rewriteCompare;

public class StudentTest {
    public static void main(String[] args) {
        //main method
        Student student = new Student(12, 123, "Janus");
        Student studentDemo = new Student(11, 125, "Lanus");
        System.out.println(student.compareTo(studentDemo));
    }
}
