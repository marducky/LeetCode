package majors.openSource.youbanWithRegex.java.category.childSong.controllers;

import majors.openSource.youbanWithRegex.java.category.audio.model.PerAudioDetail;
import majors.openSource.youbanWithRegex.java.category.audio.model.SubAudioDetails;
import majors.openSource.youbanWithRegex.java.category.childSong.services.GetPerAudioImpl;
import majors.openSource.youbanWithRegex.java.category.childSong.services.GetSubAudioImpl;

import java.util.List;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/04/18 16:14
 **/
public class ChildSongControllers {
    // no the Audio Details.
    private static final String ERGE_URL = "http://www.youbanWithRegex.com/erge/";

    public static void main_function(String url) throws Exception {
        List<SubAudioDetails> subAudioDetailsList = GetSubAudioImpl.getSubAudioDetails(url);
        subAudioDetailsList.forEach(subAudioDetails -> {
            try {
                List<PerAudioDetail> perAudioDetailList = GetPerAudioImpl.getPerAudioChildSong(subAudioDetails.getSubAudioUrl());
                subAudioDetails.setPerAudioDetails(perAudioDetailList);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void doMain() throws Exception {
        main_function(ERGE_URL);
    }
}
