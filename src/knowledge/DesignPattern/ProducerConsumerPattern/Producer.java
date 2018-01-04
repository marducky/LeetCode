package knowledge.DesignPattern.ProducerConsumerPattern;

import com.sun.beans.decoder.ValueObject;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import sun.awt.SunHints;

public class Producer {
    private String lock;
    public Producer(String lock){
        super();
        this.lock=lock;
    }
    public void setValue(){
        try {
            synchronized (lock){
                if (!knowledge.DesignPattern.ProducerConsumerPattern.ValueObject.value.equals("")){
                    lock.wait();
                }
                String value=System.currentTimeMillis()+"_"+System.nanoTime();
                System.out.println("set的值是 "+value);
                lock.notify();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
