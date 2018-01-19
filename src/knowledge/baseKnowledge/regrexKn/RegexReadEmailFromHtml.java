//http://blog.csdn.net/lhy_ycu/article/details/45501777
package knowledge.baseKnowledge.regrexKn;

import java.io.*;

public class RegexReadEmailFromHtml {
    public void getEmailFromHtml() {
        String htmlFile = "C:\\Users\\neng.qi\\Desktop\\counts.html";
        String emailTemplate = "[\\w[.-]]+@[\\w]+\\.(com||org|cn|net)";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("C:\\Users\\neng.qi\\Desktop\\counts.html"))));
            String lineText = null;
            try {
                while ((lineText = bufferedReader.readLine()) != null) {

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
