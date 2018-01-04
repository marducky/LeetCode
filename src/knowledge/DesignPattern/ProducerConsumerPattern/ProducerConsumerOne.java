package knowledge.DesignPattern.ProducerConsumerPattern;

public class ProducerConsumerOne  extends Thread{
    private Producer producer;
    public ProducerConsumerOne(Producer producer){
        super();
        this.producer=producer;
    }
    @Override
    public void run(){
        while (true){
            producer.setValue();
        }
    }
}
