package majors.openSource.youban.java.category.tangshi;

import majors.openSource.youban.java.handler.GetYouBanPageInfoHandler;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/04/17 15:20
 **/
public class TahngshiThree {
    private String tangshiListGetPattern = "<li id=\"li_(.*)\" title=\"(.*)\" [\\s\\S]*?>[\\s\\S]*?<a href=\"(.*)\">[\\s\\S]*?</li>";
    private String perTangUrlPattern = "<div class=[\\s\\S]*?<a class=[\\s\\S]*?href=\"(.*)\" target=\"_blank\">[\\s\\S]*?href=\"(.*)\" title=\"[\\s\\S]*?</a></div>";
    private String letvVedioUrlPattern = "<div class=\"FlashMainCon\"[\\s\\S]*?src=\"(.*)\">[\\s\\S]*?</div>";
    private String mp3VedioUrlPattern = "<div class=\"downloadboxlist\">[\\s\\S]*?<\\/span><a href=\"(.*)\">[\\s\\S]*?<\\/div>";
    private String letvURLFront = "http://yuntv.letv.com/bcloud.html?uu=_uuflag_&vu=_vuflag_";
    private String ssURLDemo = "http://www.flvcd.com/parse.php?format=&kw=_httputl_&sbt=%BF%AA%CA%BCGO%21";
    private String ssURLDownloadPattern = "<tr valign[\\s\\S]*?<a href=\"(.*)\" target=[\\s\\S]*?<\\/tr>";
    ArrayList<TangshiDetail> arrayLists = new ArrayList<>();

    {
        try {
            doMain();
            getPerTangshiInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setTangshiListGetPattern(String patternText, String text) {
        Pattern pattern = Pattern.compile(patternText);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            TangshiDetail tangshiDetail = new TangshiDetail();
            tangshiDetail.setName(matcher.group(2));
            tangshiDetail.setId(matcher.group(1));
            tangshiDetail.setMainUrl(matcher.group(3));
            tangshiDetail.setMp3Url(tangshiDetail.getMainUrl().replace("-", "-d"));
            arrayLists.add(tangshiDetail);
        }
    }

    private void getTangshiList(String url) throws Exception {
        GetYouBanPageInfoHandler getYouBanPageInfoHandler = new GetYouBanPageInfoHandler(url);
        setTangshiListGetPattern(tangshiListGetPattern, getYouBanPageInfoHandler.getPageInfo().toString());
    }

    private void doMain() throws Exception {
        getTangshiList("http://www.youban.com/mp3-t4416.html");
    }

    public ArrayList<TangshiDetail> getArrayLists() throws Exception {
        return arrayLists;
    }

    private void getPerTangshiInfo() {
        arrayLists.forEach(tangshiDetail -> {
            GetYouBanPageInfoHandler getYouBanPageInfoHandler = new GetYouBanPageInfoHandler(tangshiDetail.getMainUrl());
            Pattern pattern = Pattern.compile(perTangUrlPattern);
            try {
                Matcher matcher = pattern.matcher(getYouBanPageInfoHandler.getPageInfo().toString());
                while (matcher.find()) {
                    tangshiDetail.setVedioUrl(matcher.group(1).trim());
                    GetYouBanPageInfoHandler getYouBanPageInfoHandlerV = new GetYouBanPageInfoHandler(tangshiDetail.getVedioUrl());
                    Pattern patternV = Pattern.compile(letvVedioUrlPattern);
                    Matcher matcherV = patternV.matcher(getYouBanPageInfoHandlerV.getPageInfo().toString());
                    while (matcherV.find()) {
                        tangshiDetail.setLetvUrl(matcherV.group(1));
                        String uu = tangshiDetail.getLetvUrl().substring(tangshiDetail.getLetvUrl().indexOf("uu") + 3, tangshiDetail.getLetvUrl().indexOf("uu") + 13);
                        String vu = tangshiDetail.getLetvUrl().substring(tangshiDetail.getLetvUrl().indexOf("vu") + 3, tangshiDetail.getLetvUrl().indexOf("vu") + 13);
                        String pu = tangshiDetail.getLetvUrl().substring(tangshiDetail.getLetvUrl().indexOf("pu") + 3, tangshiDetail.getLetvUrl().indexOf("pu") + 13);
                        tangshiDetail.setLetvActualUrl(letvURLFront.replace("_uuflag_", uu).replace("_vuflag_", vu));
                        tangshiDetail.setSsUrl(ssURLDemo.replace("_httputl_", URLEncoder.encode(tangshiDetail.getLetvActualUrl(), "UTF-8")));
                        GetYouBanPageInfoHandler getYouBanPageInfoHandlerSS = new GetYouBanPageInfoHandler(tangshiDetail.getSsUrl());
                        Pattern patternSS = Pattern.compile(ssURLDownloadPattern);
                        Matcher matcherSS = patternSS.matcher(getYouBanPageInfoHandlerSS.getPageInfo().toString());
                        while (matcherSS.find()) {
                            tangshiDetail.setSsDownURL(matcherSS.group(1));
                        }
                    }
                }
                GetYouBanPageInfoHandler getYouBanPageInfoHandlerM = new GetYouBanPageInfoHandler(tangshiDetail.getMp3Url());
                Pattern patternM = Pattern.compile(mp3VedioUrlPattern);
                Matcher matcherM = patternM.matcher(getYouBanPageInfoHandlerM.getPageInfo().toString());
                while (matcherM.find()) {
                    tangshiDetail.setMp3DownUrl(matcherM.group(1));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) throws Exception {
        TahngshiThree tahngshiThree = new TahngshiThree();
        tahngshiThree.getArrayLists().forEach(tangshiDetail -> {
            System.out.println(tangshiDetail);
        });
    }

}


