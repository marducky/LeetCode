//http://blog.csdn.net/lhy_ycu/article/details/45501777
package knowledge.baseKnowledge.regrexKn;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexReadEmailFromHtml {
    public void getEmailFromHtml() {
        String htmlFile = "C:\\Users\\neng.qi\\Desktop\\counts.html";
        String emailTemplate = "[\\w[.-]]+@[\\w]+\\.(com|org|cn|net)";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("C:\\Users\\neng.qi\\Desktop\\counts.html"))));
            String lineText = null;
            StringBuffer sb = new StringBuffer();
            try {
                while ((lineText = bufferedReader.readLine()) != null) {
                    sb.append(lineText).append("\n");
                }
                parse(sb.toString(), emailTemplate);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void parse(String targetStr, String template) {
        if (targetStr == null || template == null) {
            return;
        }
        Pattern pattern = Pattern.compile(template);
        Matcher matcher = pattern.matcher(targetStr);
        while (matcher.find()) {
            System.out.println("======" + "\n" + matcher.group());
        }
    }

    public static void main(String[] args) {
        RegexReadEmailFromHtml regexReadEmailFromHtml = new RegexReadEmailFromHtml();
        regexReadEmailFromHtml.getEmailFromHtml();

    }


}
