package majors.openSource.chunlian_all;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @project: majors.openSource.chunlian_all
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/24 09:51
 **/
public class HtmlPageInfoHandler {

    private String name;
    private String url;
    private String regexRole2TargetBlank;
    private String regexRole2ClassContent_zw2ChunLianLine;

    public HtmlPageInfoHandler(String url, String regexRole2TargetBlank, String regexRole2ClassContent_zw2ChunLianLine) {
        this.url = url;
        this.regexRole2TargetBlank = regexRole2TargetBlank;
        this.regexRole2ClassContent_zw2ChunLianLine = regexRole2ClassContent_zw2ChunLianLine;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HtmlPageInfoHandler(String url, String regexRole) {
        this.url = url;
        this.regexRole2TargetBlank = regexRole;
    }

    public HtmlPageInfoHandler(String url, String regexRole, boolean flag) {
        this.url = url;
        if (flag == false) {
            this.regexRole2TargetBlank = regexRole;
        } else {
            this.regexRole2ClassContent_zw2ChunLianLine = regexRole;
        }

    }

    public HtmlPageInfoHandler() {
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setRegexRole2TargetBlank(String regexRole2TargetBlank) {
        this.regexRole2TargetBlank = regexRole2TargetBlank;
    }

    public void setRegexRole2ClassContent_zw2ChunLianLine(String regexRole2ClassContent_zw2ChunLianLine) {
        this.regexRole2ClassContent_zw2ChunLianLine = regexRole2ClassContent_zw2ChunLianLine;
    }

    //get the page code.
    private StringBuffer getPageInfo() throws Exception {
        StringBuffer pageInfoSb = new StringBuffer("");
        URL url = new URL(this.url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        InputStream inputStream = httpURLConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            pageInfoSb.append(line + "\n");
        }
        return pageInfoSb;
    }

    //write the page info to file.
    private void writePageToFile(String filePath, String fileName, StringBuffer contentSb) throws Exception {
        StringBuffer stringBuffer = new StringBuffer(filePath + contentSb);
        File file = new File(stringBuffer.toString());
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file);
        fw.write(contentSb.toString());
        fw.flush();
        fw.close();
    }

    //get the target of chunlian
    private ArrayList<TargetInfo> getTargetBlank(StringBuffer contentSb) {
        ArrayList<TargetInfo> targetInfoArrayList = new ArrayList<TargetInfo>();
        Pattern pattern = Pattern.compile(this.regexRole2TargetBlank);
        Matcher matcher = pattern.matcher(contentSb.toString());
        while (matcher.find()) {
            //matcher.group(0) stand for the line itself.
            TargetInfo targetInfo = new TargetInfo();
            targetInfo.setName(matcher.group(2));
            targetInfo.setSubUrl(matcher.group(1));
        }
        return targetInfoArrayList;
    }

    private ArrayList<ChunLianPageInfo> getClassContent_zw2ChunLianLine(StringBuffer contentSb) {
        ArrayList<ChunLianPageInfo> chunLianPageInfoArrayList = new ArrayList<ChunLianPageInfo>();
        Pattern pattern = Pattern.compile(this.regexRole2ClassContent_zw2ChunLianLine);
        Matcher matcher = pattern.matcher(contentSb.toString());
        ChunLianPageInfo chunLianPageInfo = new ChunLianPageInfo();
        String singleChunLian = "<p>(.*) <br />\\n(.*)</p>";
        HashMap<String, String> chunLian12 = new HashMap<String, String>();
        ArrayList<ChunLianSingle> chunLianSingles = new ArrayList<ChunLianSingle>();
        while (matcher.find()) {
            //matcher.group(0) stand for the line itself.
            chunLianPageInfo.setUrl(this.url);
            chunLianPageInfo.setTitle(matcher.group(1));
            chunLianPageInfo.setLine(matcher.group(2));
            Pattern pattern1 = Pattern.compile(singleChunLian);
            Matcher matcher1 = pattern1.matcher(matcher.group(2));
            while (matcher1.find()) {
                chunLian12.put(matcher1.group(1), matcher1.group(2));
                //222
                ChunLianSingle chunLianSingle = new ChunLianSingle();
                chunLianSingle.setFirstLine(matcher1.group(1));
                chunLianSingle.setSecondLine(matcher1.group(2));
                chunLianSingles.add(chunLianSingle);
            }
        }
        chunLianPageInfo.setHashMapArrayList(chunLian12);
        chunLianPageInfo.setChunLianSingleArrayList(chunLianSingles);
        return chunLianPageInfoArrayList;
    }

    private void getAllHtml() {
        //
    }
}
