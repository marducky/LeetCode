package majors.openSource.youbanWithRegex.java.category.audio.model;

import lombok.Data;

import java.util.List;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/04/18 13:12
 **/
@Data
public class AudioDetails {
    String audioFirstName = null;
    String audioFirstUrl = null;
    List<SubAudioDetails> subAudioDetails = null;

}
