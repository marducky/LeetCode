package majors.openSource.free_chart_nuance;

import majors.openSource.BevaSunSong.test.testlog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * @project: majors.openSource.free_chart_nuance
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/03/01 13:29
 **/
public class Server {
    int port;
    List<Socket> clients;
    ServerSocket server;
    private static Logger logger = LogManager.getLogger(Server.class);

    public static void main(String[] args) {

        new Server();
    }

    public Server() {
        try {
            port = 32156;
            clients = new ArrayList<Socket>();
            server = new ServerSocket(port);

            while (true) {
                Socket socket = server.accept();
                clients.add(socket);
                ChartThread chartThread = new ChartThread(socket);
                chartThread.start();

            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }

    class ChartThread extends Thread {
        Socket ssocket;
        private BufferedReader br;
        private PrintWriter pw;
        private String msg;

        public ChartThread(Socket s) {
            ssocket = s;
        }

        public void run() {
            Random random = new Random();
            String host = ": " + random.nextInt(100) + "";
            try {
                br = new BufferedReader(new InputStreamReader(ssocket.getInputStream()));
//                msg = "欢迎【" + ssocket.getInetAddress() + "】进入聊天室！当前聊天室有【" + clients.size() + "】人";
                msg = "欢迎【" + ssocket.getInetAddress() + host + "】进入聊天室！当前聊天室有【" + clients.size() + "】人";
                sendMsg();
                while ((msg = br.readLine()) != null) {
                    msg = "【" + ssocket.getInetAddress() + host + "】说：" + msg;
                    sendMsg();

                }
            } catch (Exception e) {
                e.printStackTrace();
                logger.error(e.getMessage());
            }
        }

        public void sendMsg() {
            try {
                System.out.println(msg);

                for (int i = clients.size() - 1; i >= 0; i--) {
                    pw = new PrintWriter(clients.get(i).getOutputStream(), true);
                    pw.println(msg);
                    pw.flush();
                }
            } catch (Exception ex) {
            }
        }
    }

}
