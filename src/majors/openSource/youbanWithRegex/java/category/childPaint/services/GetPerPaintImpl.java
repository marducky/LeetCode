package majors.openSource.youbanWithRegex.java.category.childPaint.services;

import majors.openSource.youbanWithRegex.java.category.audio.model.PerAudioDetail;
import majors.openSource.youbanWithRegex.java.handler.GetYouBanPageInfoHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/04/19 15:10
 **/
public class GetPerPaintImpl {
    private static String pageUrlPattern = "<a href=\"(.*)\" [\\s\\S]*?<span>\\d</span></a>";
    private static String pageAudioUrlPattern = "<li>[\\s\\S]*?<a target=\"_blank\" href=\"(.*)\">[\\s\\S]*?title=\"(.*)\"[\\s\\S]*?</li>";
    private static String pagePatinUrlPattern = "<div class=\"FlashMainCon\"[\\s\\S]*?<img src=\"(.*)\"[\\s\\S]*?</div>";

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
            int ee = 2;
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
            perAudioDetail.setName(matcher.group(2));
            perAudioDetail.setPaintUrl(matcher.group(1));
            GetYouBanPageInfoHandler getYouBanPageInfoHandler = new GetYouBanPageInfoHandler(perAudioDetail.getPaintUrl());
            Pattern patternV = Pattern.compile(pagePatinUrlPattern);
            Matcher matcherV = patternV.matcher(getYouBanPageInfoHandler.getPageInfo().toString());
            while (matcherV.find()) {
                perAudioDetail.setPaintDownUrl(matcherV.group(1));
            }
        }
        return perAudioDetailsList;
    }
}
