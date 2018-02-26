package majors.openSource.BevaSunSong.java;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @project: majors.openSource.BevaSunSong.java
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/26 15:11
 **/
public class DownVedioHandler {
    private String filePath;
    private String fileName;
    private String url;

    public DownVedioHandler(String filePath, String fileName, String url) {
        this.filePath = filePath;
        this.fileName = fileName;
        this.url = url;
//        write2File();
        downloadNet();

    }

    public DownVedioHandler(String fileName, String url) {
        this.filePath = "./src/majors/openSource/BevaSunSong/resource/video";
        this.fileName = fileName;
        this.url = url;
//        write2File();
        downloadNet();
    }

    public DownVedioHandler(String url) {
        this.filePath = "./src/majors/openSource/BevaSunSong/resource/video";
        this.fileName = "temp.mp4";
        this.url = url;
//        write2File();
        downloadNet();
    }

    public void downloadNet() {
        if (!this.filePath.endsWith("/")) {
            this.filePath = filePath + "/";
        }
        // 下载网络文件
        int bytesum = 0;
        int byteread = 0;

//        URL url = new URL("http://bevavideo-web.beva.cn/baf23f798ec7bacb515ac20abc88a05a/5a93aa00/22e6492089/h360/video.mp4");
        try {
            URL url = new URL(this.url);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("Host", "bevavideo-web.beva.cn");
            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1) QQBrowser/6.0");
            connection.setRequestProperty("Pragma", "no-cache");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            // 建立实际的连接
            connection.connect();
            InputStream inStream = connection.getInputStream();
            FileOutputStream fs = new FileOutputStream(filePath + "" + fileName);
            byte[] buffer = new byte[1204];
            int length;
            while ((byteread = inStream.read(buffer)) != -1) {
                bytesum += byteread;
                System.out.println(bytesum);
                fs.write(buffer, 0, byteread);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DownVedioHandler downVedioHandler = new DownVedioHandler("xianzhizhuzhidawang.mp4", "http://bevavideo-web.beva.cn/baf23f798ec7bacb515ac20abc88a05a/5a93aa00/22e6492089/h360/video.mp4");

    }
}
