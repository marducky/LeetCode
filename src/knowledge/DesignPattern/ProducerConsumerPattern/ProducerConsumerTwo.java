package knowledge.DesignPattern.ProducerConsumerPattern;

public class ProducerConsumerTwo extends Thread{
    private Consumer consumer;
    public ProducerConsumerTwo(Consumer consumer){
        super();
        this.consumer=consumer;
    }
    @Override
    public void run(){
        while (true){
            consumer.getValue();
        }
    }
}
