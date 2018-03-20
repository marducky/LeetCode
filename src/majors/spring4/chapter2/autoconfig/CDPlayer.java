package majors.spring4.chapter2.autoconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/03/19 17:40
 **/
@Component
public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;

    @Autowired
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    public void play() {


    }
}
