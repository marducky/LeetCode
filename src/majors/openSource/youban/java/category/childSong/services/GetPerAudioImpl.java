package majors.openSource.youban.java.category.childSong.services;

import majors.openSource.youban.java.category.audio.model.PerAudioDetail;
import majors.openSource.youban.java.handler.GetYouBanPageInfoHandler;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetPerAudioImpl {
    private static String pageUrlPattern = "<a href=\"(.*)\" [\\s\\S]*?<span>\\d</span></a>";
    private static String pageAudioUrlPattern = "<li>[\\s\\S]*?<a target=\"_blank\" href=\"(.*)\">[\\s\\S]*?title=\"(.*)\"[\\s\\S]*?</li>";
    private static String letvVedioUrlPattern = "<div class=\"FlashMainCon\"[\\s\\S]*?src=\"(.*)\">[\\s\\S]*?</div>";
    private static String letvURLFront = "http://yuntv.letv.com/bcloud.html?uu=_uuflag_&vu=_vuflag_";
    private static String ssURLDemo = "http://www.flvcd.com/parse.php?format=&kw=_httputl_&sbt=%BF%AA%CA%BCGO%21";
    private static String ssURLDownloadPattern = "<tr valign[\\s\\S]*?<a href=\"(.*)\" target=[\\s\\S]*?<\\/tr>";

    public static List<PerAudioDetail> getPerAudioChildSong(String url) throws Exception {
        List<PerAudioDetail> perAudioDetailsList = new ArrayList<>();
        GetYouBanPageInfoHandler getYouBanPageInfoHandler = new GetYouBanPageInfoHandler(url);
        String pageInfo = getYouBanPageInfoHandler.getPageInfo().toString();
        if (pageInfo.indexOf("<div class=\"pages\">") != -1) {
            Pattern pattern = Pattern.compile(pageUrlPattern);
            Matcher matcher = pattern.matcher(pageInfo);
            while (matcher.find()) {
                perAudioDetailsList.addAll(getPageAudioList(pageInfo, matcher.group(1)));
            }
        } else {
            perAudioDetailsList.addAll(getPageAudioList(pageInfo, url));
        }
        return perAudioDetailsList;
    }

    private static List<PerAudioDetail> getPageAudioList(String pageInfo, String url) throws Exception {
        List<PerAudioDetail> perAudioDetailsList = new ArrayList<>();
        Pattern pattern = Pattern.compile(pageAudioUrlPattern);
        Matcher matcher = pattern.matcher(pageInfo);
        while (matcher.find()) {
            PerAudioDetail perAudioDetail = new PerAudioDetail();
            perAudioDetail.setMp3Url(matcher.group(1));
            perAudioDetail.setName(matcher.group(2));
            GetYouBanPageInfoHandler getYouBanPageInfoHandler = new GetYouBanPageInfoHandler(perAudioDetail.getMp3Url());
            Pattern patternV = Pattern.compile(letvVedioUrlPattern);
            Matcher matcherV = patternV.matcher(getYouBanPageInfoHandler.getPageInfo().toString());
            while (matcherV.find()) {
                perAudioDetail.setLetvUrl(matcherV.group(1));
                String uu = perAudioDetail.getLetvUrl().substring(perAudioDetail.getLetvUrl().indexOf("uu") + 3, perAudioDetail.getLetvUrl().indexOf("uu") + 13);
                String vu = perAudioDetail.getLetvUrl().substring(perAudioDetail.getLetvUrl().indexOf("vu") + 3, perAudioDetail.getLetvUrl().indexOf("vu") + 13);
                int ee = 1;
                perAudioDetail.setLetvActualUrl(letvURLFront.replace("_uuflag_", uu).replace("_vuflag_", vu));
                perAudioDetail.setSsUrl(ssURLDemo.replace("_httputl_", URLEncoder.encode(perAudioDetail.getLetvActualUrl(), "UTF-8")));
                GetYouBanPageInfoHandler getYouBanPageInfoHandlerSS = new GetYouBanPageInfoHandler(perAudioDetail.getSsUrl());
                Pattern patternSS = Pattern.compile(ssURLDownloadPattern);
                Matcher matcherSS = patternSS.matcher(getYouBanPageInfoHandlerSS.getPageInfo().toString());
                while (matcherSS.find()) {
                    perAudioDetail.setSsDownURL(matcherSS.group(1));
                }
            }
            perAudioDetailsList.add(perAudioDetail);
        }
        return perAudioDetailsList;
    }
}
