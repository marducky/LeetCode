package majors.openSource.youbanWithRegex.java.category.audio.Services;

import majors.openSource.youbanWithRegex.java.category.audio.model.SubAudioDetails;
import majors.openSource.youbanWithRegex.java.handler.GetYouBanPageInfoHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/04/18 13:58
 **/
public class GetSubAudioImpl {
    private static String perUrlPattern = "<li onmouseover=[\\s\\S]*?href=\"(.*)\">[\\s\\S]*?title=\"(.*)\"[\\s\\S]*?</li>";

    public static List<SubAudioDetails> getSubAudioDetails(String subAudioUrl) throws Exception {
        List<SubAudioDetails> subAudioDetailsList = new ArrayList<>();
        GetYouBanPageInfoHandler getYouBanPageInfoHandler = new GetYouBanPageInfoHandler(subAudioUrl);
        Pattern pattern = Pattern.compile(perUrlPattern);
        Matcher matcher = pattern.matcher(getYouBanPageInfoHandler.getPageInfo().toString());
        while (matcher.find()) {
            SubAudioDetails subAudioDetails = new SubAudioDetails();
            subAudioDetails.setSubAudioUrl(matcher.group(1));
            subAudioDetails.setSubAudioName(matcher.group(2));
            subAudioDetailsList.add(subAudioDetails);
        }
        return subAudioDetailsList;
    }
}
