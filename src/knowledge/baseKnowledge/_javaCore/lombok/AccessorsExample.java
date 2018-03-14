package knowledge.baseKnowledge._javaCore.lombok;

import lombok.experimental.Accessors;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/03/14 13:37
 **/
@Accessors(fluent = true)
public class AccessorsExample {

    @Getter
    @Setter
    private int age = 10;
}

class PrefixExample {
    @Accessors(prefix = "f")
    @Getter
    private String fName = "Hello, World!";
}
