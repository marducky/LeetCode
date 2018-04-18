package majors.openSource.youban.java.category.audio.model;

import lombok.Data;

import java.util.List;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/04/18 13:14
 **/
@Data
public class SubAudioDetails {
    String subAudioName = null;
    String subAudioUrl = null;
    List<PerAudioDetail> perAudioDetails = null;
}
