package majors.spring4.chapter1;

import java.io.PrintStream;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/03/19 15:21
 **/
public class Minstrel {
    private PrintStream stream;

    public Minstrel() {
        this.stream = System.out;
    }

    public void singBeforeQuest() {
        stream.println("Fa la la, the knight is so brave");
    }

    public void singAfterQuest() {
        stream.println("Tee hee hee, the brave knight did embark on a quest!");
    }
}
