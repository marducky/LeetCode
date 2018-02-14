package knowledge.baseKnowledge._javaCore.international;

import java.text.DateFormat;
import java.util.Date;

/**
 * @project: knowledge.baseKnowledge._javaCore.international
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/14 14:16
 **/
public class Date22Time {
    public static void main(String[] args) {
        DateFormat format = DateFormat.getDateInstance();
        Date now = new Date();
        String s1 = format.format(now);
        System.out.println(s1);
        format = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println(format.format(now));

    }
}
