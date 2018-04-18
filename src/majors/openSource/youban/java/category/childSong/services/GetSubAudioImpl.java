package majors.openSource.youban.java.category.childSong.services;

import majors.openSource.youban.java.category.audio.model.SubAudioDetails;
import majors.openSource.youban.java.handler.GetYouBanPageInfoHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/04/18 17:33
 **/
public class GetSubAudioImpl {

    private static String ergeURLPattern = "<li><a href=\"(.*)\" target=\"_blank\"[\\s\\S]*?>(.*)</a></li>";

    public static List<SubAudioDetails> getSubAudioDetails(String url) throws Exception {
        List<SubAudioDetails> subAudioDetailsList = new ArrayList<>();
        GetYouBanPageInfoHandler getYouBanPageInfoHandler = new GetYouBanPageInfoHandler(url);
        Pattern pattern = Pattern.compile(ergeURLPattern);
        Matcher matcher = pattern.matcher(getYouBanPageInfoHandler.getPageInfo().toString());
        while (matcher.find()) {
            SubAudioDetails subAudioDetails = new SubAudioDetails();
            subAudioDetails.setSubAudioUrl(matcher.group(1));
            String ss = "";
            subAudioDetails.setSubAudioName(matcher.group(2));
            subAudioDetailsList.add(subAudioDetails);
        }
        return subAudioDetailsList;
    }
}
