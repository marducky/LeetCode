package majors.openSource.youban.java.Tangshi;

import majors.openSource.youban.java.GetYouBanPageInfoHandler;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tangshi {
    String tangshiListGetPattern = "<li id=\"li_(.*)\" title=\"(.*)\" [\\s\\S]*?>[\\s\\S]*?<a href=\"(.*)\">[\\s\\S]*?</li>";
    String perTangUrlPattern = "<div class=[\\s\\S]*?<a class=[\\s\\S]*?href=\"(.*)\" target=\"_blank\">[\\s\\S]*?href=\"(.*)\" title=\"[\\s\\S]*?</a></div>";
    String letvVedioUrlPattern = "<div class=\"FlashMainCon\"[\\s\\S]*?src=\"(.*)\">[\\s\\S]*?</div>";
    String mp3VedioUrlPattern = "<div class=\"downloadboxlist\">[\\s\\S]*?</span><a href=\"(.*)\">[\\s\\S]*?</div>";
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
            arrayLists.add(tangshiDetail);

        }
    }

    private void getTangshiList(String url) throws Exception {
//        GetYouBanPageInfoHandler getYouBanPageInfoHandler = new GetYouBanPageInfoHandler("http://www.youban.com/mp3-t4416.html");
        GetYouBanPageInfoHandler getYouBanPageInfoHandler = new GetYouBanPageInfoHandler(url);
        setTangshiListGetPattern(tangshiListGetPattern, getYouBanPageInfoHandler.getPageInfo().toString());
    }

    private void doMain() throws Exception {
        getTangshiList("http://www.youban.com/mp3-t4416.html");
    }

    public ArrayList<TangshiDetail> getArrayLists() throws Exception {
        return arrayLists;
    }

    //================================================
    //begin per

    private void getPerTangshiInfo() {

        arrayLists.forEach(tangshiDetail -> {
            GetYouBanPageInfoHandler getYouBanPageInfoHandler = new GetYouBanPageInfoHandler(tangshiDetail.getMainUrl());
            Pattern pattern = Pattern.compile(perTangUrlPattern);
            try {
                Matcher matcher = pattern.matcher(getYouBanPageInfoHandler.getPageInfo().toString());
                while (matcher.find()) {
//                    System.out.println(matcher.group(1));
//                    System.out.println(matcher.group(2));
                    tangshiDetail.setVedioUrl(matcher.group(1).trim());
                    //=========================
                    //begin vedio
                    GetYouBanPageInfoHandler getYouBanPageInfoHandlerV = new GetYouBanPageInfoHandler(tangshiDetail.getVedioUrl());
                    Pattern patternV = Pattern.compile(letvVedioUrlPattern);
                    Matcher matcherV = patternV.matcher(getYouBanPageInfoHandlerV.getPageInfo().toString());
                    while (matcherV.find()) {
                        tangshiDetail.setLetvUrl(matcherV.group(1));
                    }
                    //==================
                    //change to get shuoshu url
                    //demo:http://yuntv.letv.com/bcloud.html?uu=3ba971f8f7&vu=f78b7ee3fa


                    //=========================
                    //get shuoshu url page info:
                    //demo: http://www.flvcd.com/parse.php?format=&kw=http%3A%2F%2Fyuntv.letv.com%2Fbcloud.html%3Fuu%3De83fdad654%26pu%3D55087b3b4d%26vu%3D1481a95071&sbt=%BF%AA%CA%BCGO%21
                    //shuoshu: http://www.flvcd.com/index.htm


                    tangshiDetail.setMp3Url(matcher.group(2).trim());
                    //=========================
                    GetYouBanPageInfoHandler getYouBanPageInfoHandlerM = new GetYouBanPageInfoHandler(tangshiDetail.getMp3Url());
                    Pattern patternM = Pattern.compile(mp3VedioUrlPattern);
                    Matcher matcherM = patternM.matcher(getYouBanPageInfoHandlerM.getPageInfo().toString());
                    while (matcherM.find()) {
                        tangshiDetail.setMp3DownUrl(matcherV.group(1));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


}
