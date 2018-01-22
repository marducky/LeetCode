package knowledge.baseKnowledge.regrexKn;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindSubString {
    private static ArrayList<String> findSubStrings(String giveStr, String resultTemplate) {
        ArrayList<String> stringArrayList = new ArrayList<String>();
        Pattern pattern = Pattern.compile(resultTemplate);
        Matcher matcher = pattern.matcher(giveStr);
        while (matcher.find()) {
            stringArrayList.add(matcher.group());
        }
        System.out.println(matcher.matches());
        matcher.reset();
        System.out.println(matcher.find());
        System.out.println(matcher.start() + "-" + matcher.end());
        System.out.println(matcher.lookingAt());
        System.out.println(matcher.lookingAt());
        return stringArrayList;

    }

    public static void main(String[] args) {
        String s1 = "abc-234-se4-454542222223444234eee-12";
        String template = "\\d{3,5}";
        ArrayList<String> arrayList = findSubStrings(s1, template);
        for (String s : arrayList) {
            System.out.println(s);
        }
    }
}
