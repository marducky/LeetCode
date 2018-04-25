package majors.openSource.youbanWithRegex.java.category.audio.Services;

import majors.openSource.youbanWithRegex.java.category.audio.model.PerAudioDetail;
import majors.openSource.youbanWithRegex.java.category.tangshi.TangshiDetail;
import majors.openSource.youbanWithRegex.java.handler.GetYouBanPageInfoHandler;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/04/18 15:12
 **/
public class GetPerAudioImpl {
    private static String tangshiListGetPattern = "<li id=\"li_(.*)\" title=\"(.*)\" [\\s\\S]*?>[\\s\\S]*?<a href=\"(.*)\">[\\s\\S]*?</li>";
    private static String perTangUrlPattern = "<div class=[\\s\\S]*?<a class=[\\s\\S]*?href=\"(.*)\" target=\"_blank\">[\\s\\S]*?href=\"(.*)\" title=\"[\\s\\S]*?</a></div>";
    private static String letvVedioUrlPattern = "<div class=\"FlashMainCon\"[\\s\\S]*?src=\"(.*)\">[\\s\\S]*?</div>";
    private static String mp3VedioUrlPattern = "<div class=\"downloadboxlist\">[\\s\\S]*?<\\/span><a href=\"(.*)\">[\\s\\S]*?<\\/div>";
    private static String letvURLFront = "http://yuntv.letv.com/bcloud.html?uu=_uuflag_&vu=_vuflag_";
    private static String ssURLDemo = "http://www.flvcd.com/parse.php?format=&kw=_httputl_&sbt=%BF%AA%CA%BCGO%21";
    private static String ssURLDownloadPattern = "<tr valign[\\s\\S]*?<a href=\"(.*)\" target=[\\s\\S]*?<\\/tr>";

    public static List<PerAudioDetail> getPerAudioDetailsList(String perAudioURL) throws Exception {
        List<PerAudioDetail> perAudioDetails = new ArrayList<>();
        GetYouBanPageInfoHandler getYouBanPageInfoHandler = new GetYouBanPageInfoHandler(perAudioURL);
        Pattern pattern = Pattern.compile(tangshiListGetPattern);
        Matcher matcher = pattern.matcher(getYouBanPageInfoHandler.getPageInfo().toString());
        while (matcher.find()) {
            PerAudioDetail perAudioDetail = new PerAudioDetail();
            perAudioDetail.setName(matcher.group(2));
            perAudioDetail.setId(matcher.group(1));
            perAudioDetail.setMainUrl(matcher.group(3));
            perAudioDetail.setMp3Url(perAudioDetail.getMainUrl().replace("-", "-d"));
            GetYouBanPageInfoHandler getYouBanPageInfoHandler1 = new GetYouBanPageInfoHandler(perAudioDetail.getMainUrl());
            Pattern pattern1 = Pattern.compile(perTangUrlPattern);
            try {
                Matcher matcher1 = pattern1.matcher(getYouBanPageInfoHandler1.getPageInfo().toString());
                while (matcher1.find()) {
                    perAudioDetail.setVedioUrl(matcher.group(1).trim());
                    GetYouBanPageInfoHandler getYouBanPageInfoHandlerV = new GetYouBanPageInfoHandler(perAudioDetail.getVedioUrl());
                    Pattern patternV = Pattern.compile(letvVedioUrlPattern);
                    Matcher matcherV = patternV.matcher(getYouBanPageInfoHandlerV.getPageInfo().toString());
                    while (matcherV.find()) {
                        perAudioDetail.setLetvUrl(matcherV.group(1));
                        String uu = perAudioDetail.getLetvUrl().substring(perAudioDetail.getLetvUrl().indexOf("uu") + 3, perAudioDetail.getLetvUrl().indexOf("uu") + 13);
                        String vu = perAudioDetail.getLetvUrl().substring(perAudioDetail.getLetvUrl().indexOf("vu") + 3, perAudioDetail.getLetvUrl().indexOf("vu") + 13);
                        String pu = "";
                        perAudioDetail.setLetvActualUrl(letvURLFront.replace("_uuflag_", uu).replace("_vuflag_", vu));
                        perAudioDetail.setSsUrl(ssURLDemo.replace("_httputl_", URLEncoder.encode(perAudioDetail.getLetvActualUrl(), "UTF-8")));
                        GetYouBanPageInfoHandler getYouBanPageInfoHandlerSS = new GetYouBanPageInfoHandler(perAudioDetail.getSsUrl());
                        Pattern patternSS = Pattern.compile(ssURLDownloadPattern);
                        Matcher matcherSS = patternSS.matcher(getYouBanPageInfoHandlerSS.getPageInfo().toString());
                        while (matcherSS.find()) {
                            perAudioDetail.setSsDownURL(matcherSS.group(1));
                        }
                    }
                }
                GetYouBanPageInfoHandler getYouBanPageInfoHandlerM = new GetYouBanPageInfoHandler(perAudioDetail.getMp3Url());
                Pattern patternM = Pattern.compile(mp3VedioUrlPattern);
                Matcher matcherM = patternM.matcher(getYouBanPageInfoHandlerM.getPageInfo().toString());
                while (matcherM.find()) {
                    perAudioDetail.setMp3DownUrl(matcherM.group(1));
                }
            } catch (Exception e) {
                e.printStackTrace();

            }
            perAudioDetails.add(perAudioDetail);
        }

        return perAudioDetails;
    }
}
