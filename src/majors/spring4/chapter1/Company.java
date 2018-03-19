package majors.spring4.chapter1;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/03/19 17:03
 **/
//@Data
public class Company {
    @Setter
    @Getter
    private String nId;
    @Setter
    @Getter
    private String nCompanyName;
}
