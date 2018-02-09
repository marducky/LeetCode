package knowledge.baseKnowledge._javaCore.javaSocket;

import java.io.OutputStream;
import java.net.Socket;

public class SockerClient {
    public static void main(String[] args) throws Exception {
        //main method
        String host = "127.0.0.1";
        int port = 55533;
        Socket socket = new Socket(host, port);
        OutputStream outputStream = socket.getOutputStream();
        String message = "Hello Janus>>>>>";
        socket.getOutputStream().write(message.getBytes("UTF-8"));
        outputStream.close();
        socket.close();
    }
}
