package majors.spring4.chapter1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/03/19 15:42
 **/
public class KnightsMain {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("majors/spring4/spring.xml");
        Knights knights = (Knights) ctx.getBean("knight");
        knights.embarkOnQuest();
        ctx.close();

    }
}
