package majors.openSource.youban.java.category.childSong.controllers;

import majors.openSource.youban.java.category.audio.model.PerAudioDetail;
import majors.openSource.youban.java.category.audio.model.SubAudioDetails;
import majors.openSource.youban.java.category.childSong.services.GetPerAudioImpl;
import majors.openSource.youban.java.category.childSong.services.GetSubAudioImpl;

import java.util.List;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/04/18 16:14
 **/
public class ChildSongControllers {
    // no the Audio Details.
    public static void main_function() throws Exception {
        List<SubAudioDetails> subAudioDetailsList = GetSubAudioImpl.getSubAudioDetails();
        subAudioDetailsList.forEach(subAudioDetails -> {
            try {
                List<PerAudioDetail> perAudioDetailList = GetPerAudioImpl.getPerAudioChildSong(subAudioDetails.getSubAudioUrl());
                subAudioDetails.setPerAudioDetails(perAudioDetailList);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
