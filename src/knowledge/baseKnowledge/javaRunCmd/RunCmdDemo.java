package knowledge.baseKnowledge.javaRunCmd;

import java.io.IOException;

public class RunCmdDemo {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        try {
            runtime.exec("javaInherit -version");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
