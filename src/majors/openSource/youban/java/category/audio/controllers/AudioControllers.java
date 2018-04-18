package majors.openSource.youban.java.category.audio.controllers;


import lombok.extern.slf4j.Slf4j;
import majors.openSource.youban.java.category.audio.Services.GetAudioImpl;
import majors.openSource.youban.java.category.audio.Services.GetPerAudioImpl;
import majors.openSource.youban.java.category.audio.Services.GetSubAudioImpl;
import majors.openSource.youban.java.category.audio.model.AudioDetails;
import majors.openSource.youban.java.category.audio.model.PerAudioDetail;
import majors.openSource.youban.java.category.audio.model.SubAudioDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/04/18 13:22
 **/
@Slf4j
public class AudioControllers {
    public static void main_Function() throws Exception {
        List<AudioDetails> audioDetailsList = GetAudioImpl.getAudioList();
        audioDetailsList.forEach(audioDetails -> {
            List<SubAudioDetails> subAudioDetailsList = new ArrayList<>();
            try {
                subAudioDetailsList = GetSubAudioImpl.getSubAudioDetails(audioDetails.getAudioFirstUrl());
                subAudioDetailsList.forEach(subAudioDetails -> {
                    try {
                        List<PerAudioDetail> perAudioDetailList = GetPerAudioImpl.getPerAudioDetailsList(subAudioDetails.getSubAudioUrl());
                        subAudioDetails.setPerAudioDetails(perAudioDetailList);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            } catch (Exception e) {
                log.info(e.getMessage());
            }
            audioDetails.setSubAudioDetails(subAudioDetailsList);
        });
    }
}
