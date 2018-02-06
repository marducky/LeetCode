package knowledge.baseKnowledge.regrexKn;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindAndChange {
    private static long countPreNext;
    private String giveStrString;
    private String giveStrPer;

    public void FindAndChange(String giveStrString, String giveStrPer) {
        this.giveStrPer = giveStrPer;
        this.giveStrString = giveStrString;
    }

    public int findCounter(String giveStrString, String giveStrPer) {
        int res = 0;
        Pattern pattern = Pattern.compile(giveStrPer);
        Matcher matcher = pattern.matcher(giveStrString);
        res = matcher.groupCount();
        return res;
    }

    public void next() {

    }

    public static long getCountPreNext() {
        return countPreNext;
    }

    public static void setCountPreNext(long countPreNext) {
        FindAndChange.countPreNext = countPreNext;
    }

    public String getGiveStrString() {
        return giveStrString;
    }

    public void setGiveStrString(String giveStrString) {
        this.giveStrString = giveStrString;
    }

    public String getGiveStrPer() {
        return giveStrPer;
    }

    public void setGiveStrPer(String giveStrPer) {
        this.giveStrPer = giveStrPer;
    }

    public static void main(String[] args) {


        // CASE_INSENSITIVE：忽略子串大小写
        Pattern pattern2 = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
        Matcher matcher2 = pattern2.matcher("javaInherit Java JAVA jaVA jAVA ILoveYouJaVA youhateJaVa");
        // 将查找到的所有子串进行替换 （查找并替换）
        System.out.println(matcher2.replaceAll("JAVA"));
    }
}
