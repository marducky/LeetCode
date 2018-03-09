package majors.spring4.AxeDemo;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @project: majors.spring4.Axe
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/03/09 17:08
 **/
public class BeanTestUseReflect {
    public static void main(String[] args) {
//        Chinese p = new Chinese();
//        StoneAxe axe = new StoneAxe();
//        p.setAxe(axe);
//        p.useAxe();

//            @Before
        ApplicationContext ctx = new ClassPathXmlApplicationContext("majors/spring4/spring.xml");
        Person p = ctx.getBean("chinese", Person.class);
        p.useAxe();

    }
}
