package knowledge.multiProcess.chapter0.volatileKn;

public class VolatileMoreKne {
    public volatile int inc=0;
    public void increase(){
        inc++;
    }
    public static void main(String[] args){
        final VolatileMoreKne volatileMoreKne=new VolatileMoreKne();
        for (int i=0;i<10;i++){
            new Thread(){
                public void run(){
                    for (int j=0;j<10;j++)
                        volatileMoreKne.increase();
                };
            }.start();
        }
        while (Thread.activeCount()>1)
            Thread.yield();
        System.out.println(volatileMoreKne.inc);
    }
}
