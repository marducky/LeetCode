package majors.spring4.chapter1;

import java.io.PrintStream;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/03/19 14:48
 **/
public class SlayDragonQuest implements Quest {
    private PrintStream stream;

    public SlayDragonQuest(PrintStream stream) {
        this.stream = stream;
    }

    public void embark() {
//        System.out.println("I am SlayDragonQuest!");
        stream.println("Embarking on quest to slay the dragon!");
    }
}
