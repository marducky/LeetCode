package majors.openSource.free_chart_nuance;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

/**
 * @project: majors.openSource.free_chart_nuance
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/03/01 13:45
 **/
public class Client {
    public int port = 32156;
    Socket socket = null;
    private static Logger logger = LogManager.getLogger(Client.class);

    public static void main(String[] args) {
        new Client();
    }

    public Client() {
        Random random = new Random();
        String host = random.nextInt(100) + "." + random.nextInt(100) + "." + random.nextInt(100) + "." + random.nextInt(100);
        try {

            socket = new Socket("127.0.0.1", port);

            new Cthread().start();

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg1;
            while ((msg1 = br.readLine()) != null) {

                System.out.println(msg1);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    class Cthread extends Thread {

        public void run() {
            try {

                BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
                String msg2;

                while (true) {

                    msg2 = re.readLine();
                    pw.println(msg2);
                }
            } catch (Exception e) {
                e.printStackTrace();
                logger.error(e.getMessage());
            }


        }
    }
}
