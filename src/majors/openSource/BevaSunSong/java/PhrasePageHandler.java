package majors.openSource.BevaSunSong.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @project: majors.openSource.BevaSunSong.java
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/26 11:41
 **/
public class PhrasePageHandler {
    private String regexRole;
    private Object objectContent;

    public PhrasePageHandler(String regexRole, Object objectContent) {
        this.regexRole = regexRole;
        this.objectContent = objectContent;
    }

    public int phrasePageTotalVideo() {
        int res = 0;
        Pattern p = Pattern.compile(regexRole);
        Matcher m = p.matcher(objectContent.toString());
        while (m.find()) {
            res = Integer.valueOf(m.group(1));
        }
        return res;
    }
}
