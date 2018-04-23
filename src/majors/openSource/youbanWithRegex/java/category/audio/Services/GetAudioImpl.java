package majors.openSource.youbanWithRegex.java.category.audio.Services;

import majors.openSource.youbanWithRegex.java.category.audio.model.AudioDetails;
import majors.openSource.youbanWithRegex.java.handler.GetYouBanPageInfoHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/04/18 13:26
 **/
public class GetAudioImpl {
    private static final String MP3_URL = "http://www.youbanWithRegex.com/mp3/";
    private static String subAudioPattern = "<li><a href=\"(.*)\" target=\"_blank\"[\\s\\S]*?>(.*)</a></li>";

    public static List<AudioDetails> getAudioList() throws Exception {
        List<AudioDetails> audioDetailsList = new ArrayList<>();
        GetYouBanPageInfoHandler getYouBanPageInfoHandler = new GetYouBanPageInfoHandler(MP3_URL);
        Pattern pattern = Pattern.compile(subAudioPattern);
        Matcher matcher = pattern.matcher(getYouBanPageInfoHandler.getPageInfo().toString());
        while (matcher.find()) {
            if (matcher.group(1).indexOf("mp3-c") == -1) {
                AudioDetails audioDetails = new AudioDetails();
                audioDetails.setAudioFirstName(matcher.group(2));
                audioDetails.setAudioFirstUrl(matcher.group(1));
                audioDetailsList.add(audioDetails);
            }

        }
        return audioDetailsList;
    }
}
