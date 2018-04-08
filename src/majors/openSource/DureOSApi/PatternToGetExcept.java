package majors.openSource.DureOSApi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternToGetExcept {

    public static void getExcept(String xText) {
        String url = "[<div>]*?(.*)[</div>]*?<ul>[<li>(.*)</li>]*?(.*)</ul>(.*)";
        Pattern pattern = Pattern.compile(url);
        Matcher matcher = pattern.matcher(xText);
        int i = 0;
//        System.out.println(matcher.find());
        while (matcher.find()) {
            System.out.println(matcher.group(2));
        }


    }

    public static void main(String[] args) {
        //main method
        String xText = "Do you mean<ul><li><a href=\"#\" data-vtz-link-type=\"Dialog\" data-vtz-reword-index=\"1\" data-vtz-interaction-index=\"2\" data-vtz-jump=\"4861704621517852538\">Can I use my routing number to receive international wire transfers?</a></li><li>ssssss</li></ul>";
        getExcept(xText);
    }
}
