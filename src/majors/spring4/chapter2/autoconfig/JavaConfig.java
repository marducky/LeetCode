package majors.spring4.chapter2.autoconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/03/20 10:26
 **/
//@Configuration
public class JavaConfig {
    @Bean(name = "lonelyHeartClubBand")
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }
}
