package majors.spring4.chapter2.autoconfig;

import org.springframework.stereotype.Component;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/03/19 17:17
 **/
//@Component
public class SgtPeppers implements CompactDisc {
    private String title = "Stg, Pepper's Lonely Hearts Club Band";
    private String artist = "The beatles";

    public void play() {


        System.out.println("Playing " + title + " By " + artist);
    }
}
