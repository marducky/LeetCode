package knowledge.baseKnowledge.keyMapKn.finalKn;

public class CompareFinalAndCommonTwo {
    public static void main(String[] args) {
        String a = "hello2";
        final String b = getHello();
        String c = b + 2;
        System.out.println((a == c));

    }

    public static String getHello() {
        return "hello";
    }
}
