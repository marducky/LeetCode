package majors.openSource.DureOSApi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternToGetExcept {

    public static void getExcept(String xText) {
        String url = "[<div>]*?(.*)[</div>]*?.*<ul>(<li>.*</li>)*?</ul>.*";
        Pattern pattern = Pattern.compile(url);
        Matcher matcher = pattern.matcher(xText);
        int i = 0;
//        System.out.println(matcher.find());
        while (matcher.find()) {
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            if (matcher.group(2) != null) {
                String s = matcher.group(2).replaceAll("<li>", "** ").replaceAll("</li>", "\n");
            }
            System.out.println(matcher.groupCount());
//            System.out.println(matcher.group(3));
        }


    }

    public static void main(String[] args) {
        //main method
        String xText1 = "Do you mean<ul><li><a href=\"#\" data-vtz-link-type=\"Dialog\" data-vtz-reword-index=\"1\" data-vtz-interaction-index=\"2\" data-vtz-jump=\"4861704621517852538\">Can I use my routing number to receive international wire transfers?</a></li><li>ssssss</li></ul>";
        String xText = "Do you mean<ul></ul>";
        getExcept(xText);
    }
}


