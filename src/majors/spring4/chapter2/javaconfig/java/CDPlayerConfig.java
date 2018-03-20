package majors.spring4.chapter2.javaconfig.java;

import majors.spring4.chapter2.autoconfig.CompactDisc;
import majors.spring4.chapter2.autoconfig.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/03/20 10:37
 **/
@Configuration
public class CDPlayerConfig {

    @Bean
    public CompactDisc compactDisc() {
        return new SgtPeppers();
    }

    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc) {
        return new CDPlayer(compactDisc);
    }

}
