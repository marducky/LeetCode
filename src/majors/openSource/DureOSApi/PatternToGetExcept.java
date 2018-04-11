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

    public static void getXieKuohaoNull(String xText) {
//        System.out.println(xText.replaceFirst("<li>","\n* ").replaceAll("<li>","* ").replaceAll("</li>","\n").replaceAll("<.*?>",""));
//        System.out.print(xText.replaceAll("<li>", "\n* ").replaceAll("<.*?>", ""));
        System.out.print(xText.replaceFirst("<li>", " ").replaceAll("<li>", " Or ").replaceAll("<.*?>", ""));
    }

    public static void main(String[] args) {
        //main method
        String xText1 = "Do you mean<ul><li><a href=\"#\" data-vtz-link-type=\"Dialog\" data-vtz-reword-index=\"1\" data-vtz-interaction-index=\"2\" data-vtz-jump=\"4861704621517852538\">Can I use my routing number to receive international wire transfers?</a></li><li>ssssss</li></ul>";
        String xText = "Do you mean<ul></ul>";
        String XText = "Sure.  From which account? <ul><li><a href=\\\"#\\\" data-vtz-link-type=\\\"Dialog\\\" data-vtz-jump=\\\"da08e0b6-7294-4c6f-be5f-2124b2722786\\\">Checking - $8,345.01</a></li><li><a href=\\\"#\\\" data-vtz-link-type=\\\"Dialog\\\" data-vtz-jump=\\\"ec00700b-c29b-4ada-9bf0-9f9cbc7d2320\\\">Savings - $12,762.90</a></li><li><a href=\\\"#\\\" data-vtz-link-type=\\\"Dialog\\\" data-vtz-jump=\\\"12ff2334-0e85-44aa-96ab-3464df720ce2\\\">Brokerage - $34,981.76</a></li></ul>";
        String XText1 = "Do you mean<ul><li><a href=\\\"#\\\" data-vtz-link-type=\\\"Dialog\\\" data-vtz-reword-index=\\\"1\\\" data-vtz-interaction-index=\\\"1\\\" data-vtz-jump=\\\"4861839208613039994\\\">How do I find the status of a money transfer</a></li></ul>";
//        getExcept(xText);
//        System.out.println(XText);
//        getXieKuohaoNull(XText);
        getXieKuohaoNull(XText1);
    }

}


