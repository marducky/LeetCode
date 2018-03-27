package majors.spring4.chapter4;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/03/27 16:34
 **/
@Aspect
public class Audience {
    @Before("execution(**majors.spring4.chapter4.Performance4.perform(..))")
    public void silenceCellPhones() {
        System.out.println("silenceCellPhones");
    }

    @Before("execution(**majors.spring4.chapter4.Performance4.perform(..))")
    public void TakingSeat() {
        System.out.println("TakingSeat");
    }

    @AfterReturning("execution(**majors.spring4.chapter4.Performance4.perform(..))")
    public void applause() {
        System.out.println("applause");
    }

    @AfterThrowing("execution(**majors.spring4.chapter4.Performance4.perform(..))")
    public void demandRefund() {
        System.out.println("applause");
    }
}
