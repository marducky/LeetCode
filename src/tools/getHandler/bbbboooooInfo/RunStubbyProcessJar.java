package tools.getHandler.bbbboooooInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class RunStubbyProcessJar implements Runnable {
    InputStream stream;
    StringBuilder output;

    public RunStubbyProcessJar(InputStream stream) {
        this.stream = stream;
        this.output = new StringBuilder();
    }

    public void run() {
        try {
            try {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(this.stream));
                String line = br.readLine();
                while (line != null) {
                    if (line.trim().length() > 0) {
                        output.append(line).append("\n");
                    }
                    line = br.readLine();
                }
            } finally {
                if (stream != null) {
                    stream.close();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }

    public static void main(String[] args) {
        try {
//            String abPath=RunStubbyProcessJar.class.getResource("").toString().substring(RunStubbyProcessJar.class.getResource("").toString().indexOf("/") + 1, RunStubbyProcessJar.class.getResource("").toString().length());
            String abPathForJar = RunStubbyProcessJar.class.getResource("stubby4j-5.1.1.jar").toString().substring(RunStubbyProcessJar.class.getResource("stubby4j-5.1.1.jar").toString().indexOf("/") + 1, RunStubbyProcessJar.class.getResource("stubby4j-5.1.1.jar").toString().length());
            String abPathForYml = RunStubbyProcessJar.class.getResource("NinaTest.yaml").toString().substring(RunStubbyProcessJar.class.getResource("NinaTest.yaml").toString().indexOf("/") + 1, RunStubbyProcessJar.class.getResource("NinaTest.yaml").toString().length());
            String cmdPath1 = "java -jar " + abPathForJar + " -d " + abPathForYml;
            String cmdPath2 = "java -jar stubby4j-5.1.1.jar -d NinaTest.yaml";
            String command2 = "java -jar G:\\info\\NLPS_Code_Repos\\git\\LeetCode\\src\\knowledge\\baseKnowledge\\javaRunCmd\\stubby4j-5.1.1.jar -d G:\\info\\NLPS_Code_Repos\\git\\LeetCode\\src\\knowledge\\baseKnowledge\\javaRunCmd\\NinaTest.yaml";
//            Process p1 = Runtime.getRuntime().exec(cmdPath1);
//            Process p2 = Runtime.getRuntime().exec(cmdPath2);
            Process p = Runtime.getRuntime().exec(command2);
            RunStubbyProcessJar errorStream = new RunStubbyProcessJar(p.getErrorStream());
            RunStubbyProcessJar outputStream = new RunStubbyProcessJar(p.getInputStream());
            new Thread(errorStream).start();
            new Thread(outputStream).start();
            p.waitFor();

            String result = command2 + "\n" + outputStream.output.toString()
                    + errorStream.output.toString();
            System.out.print(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

