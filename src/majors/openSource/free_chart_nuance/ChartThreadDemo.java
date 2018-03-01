package majors.openSource.free_chart_nuance;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @project: majors.openSource.free_chart_nuance
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/03/01 13:35
 **/
public class ChartThreadDemo extends Thread {
    Socket ssocket;
    private BufferedReader br;
    private PrintWriter pw;
    private String msg;

    private static Logger logger = LogManager.getLogger(ChartThreadDemo.class);

    public ChartThreadDemo(Socket s) {
        ssocket = s;
    }

    public void run() {
        try {
            br = new BufferedReader(new InputStreamReader(ssocket.getInputStream()));
            msg = "欢迎【" + ssocket.getInetAddress() + "】进入聊天室！当前聊天室有【" + "】人";
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }
}
