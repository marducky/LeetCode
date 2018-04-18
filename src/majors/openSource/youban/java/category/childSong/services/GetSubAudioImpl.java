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
    private static final String ERGE_URL = "http://www.youban.com/erge/";
    private static String ergeURLPattern = "<li><a href=\"(.*)\" target=\"_blank\" class=\"red\">(.*)</a></li>";

    public static List<SubAudioDetails> getSubAudioDetails() throws Exception {
        List<SubAudioDetails> subAudioDetailsList = new ArrayList<>();
        GetYouBanPageInfoHandler getYouBanPageInfoHandler = new GetYouBanPageInfoHandler(ERGE_URL);
        Pattern pattern = Pattern.compile(ergeURLPattern);
        Matcher matcher = pattern.matcher(getYouBanPageInfoHandler.getPageInfo().toString());

        return subAudioDetailsList;
    }
}
