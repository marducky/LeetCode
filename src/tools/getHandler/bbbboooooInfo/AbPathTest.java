package tools.getHandler.bbbboooooInfo;

import java.io.File;

public class AbPathTest {
    public static void main(String[] args) {
        String abPath = RunStubbyProcessJar.class.getResource("").toString().substring(RunStubbyProcessJar.class.getResource("").toString().indexOf("/") + 1, RunStubbyProcessJar.class.getResource("").toString().length());
        String abPathForJar = RunStubbyProcessJar.class.getResource("stubby4j-5.1.1.jar").toString().substring(RunStubbyProcessJar.class.getResource("stubby4j-5.1.1.jar").toString().indexOf("/") + 1, RunStubbyProcessJar.class.getResource("stubby4j-5.1.1.jar").toString().length());
        String abPathForYml = RunStubbyProcessJar.class.getResource("NinaTest.yaml").toString().substring(RunStubbyProcessJar.class.getResource("NinaTest.yaml").toString().indexOf("/") + 1, RunStubbyProcessJar.class.getResource("NinaTest.yaml").toString().length());
        String cmdPath = "java -jar " + abPathForJar + " -d " + abPathForYml;
        System.out.println(abPath);
        System.out.println(abPathForJar);
        System.out.println(abPathForYml);
        System.out.println(cmdPath);
        System.out.println(System.getProperty("user.dir"));
        File file = new File("/src");
        System.out.println(file.exists());
        System.out.println(AbPathTest.class.getClassLoader().getResourceAsStream("").toString());

    }
}
