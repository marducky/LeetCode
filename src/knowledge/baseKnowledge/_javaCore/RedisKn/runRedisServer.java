package knowledge.baseKnowledge._javaCore.RedisKn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class runRedisServer implements Runnable {
    InputStream stream;
    StringBuilder output;

    public runRedisServer(InputStream stream) {
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

            String command2 = "./src/knowledge/baseKnowledge/_javaCore/RedisKn/RedisX64/redis-server.exe ./src/knowledge/baseKnowledge/_javaCore/RedisKn/RedisX64/redis.windows.conf";
            Process p = Runtime.getRuntime().exec(command2);
            runRedisServer errorStream = new runRedisServer(p.getErrorStream());
            runRedisServer outputStream = new runRedisServer(p.getInputStream());
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

