package knowledge.baseKnowledge.regrexKn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestGangT {
    public static void main(String[] args) {
        String sss = "d\t";
        String sssss = "\\t";
        Pattern pattern = Pattern.compile(sssss);
        Matcher matcher = pattern.matcher(sss);
        int c = 0;
//        System.out.println(matcher.lookingAt());
//        System.out.println(matcher.end());
        while (matcher.find()) {
            c++;
//            System.out.println(matcher.groupCount()+c);
            System.out.println(matcher.end());
            System.out.println(matcher.start());
        }
//        System.out.println(c);
    }
}
