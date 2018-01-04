package knowledge.DesignPattern.ProducerConsumerPattern;

public class ProducerConsumerRun extends Thread{
  public static void main(String[] args){
      String lock=new String("");
      Producer producer=new Producer(lock);
      Consumer consumer=new Consumer(lock);
      ProducerConsumerOne producerConsumerOne=new ProducerConsumerOne(producer);
      ProducerConsumerTwo producerConsumerTwo=new ProducerConsumerTwo(consumer);
      producerConsumerOne.start();
      producerConsumerTwo.start();
  }
}
