package tools.getHandler.ccccoooInfo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
//            System.out.println(matcher.end());
//            System.out.println(matcher.start());
        }
        String sass = "{\"PA_Service_Name\":\"pa_flag\",\"UserText\":\"text_flag\"}";
        String pa_pattren = "\"spa_flag\"";
        System.out.println(sass.indexOf(pa_pattren));
        DateFormat df = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        System.out.println(df.format(new Date(System.currentTimeMillis())));
//        System.out.println(c);
    }
}
