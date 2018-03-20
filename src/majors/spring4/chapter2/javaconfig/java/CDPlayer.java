package majors.spring4.chapter2.javaconfig.java;

import majors.spring4.chapter2.autoconfig.CompactDisc;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/03/20 10:36
 **/
public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;

    @Autowired
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    public void play() {
        cd.play();
    }

}
