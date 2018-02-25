package majors.openSource.BevaSunSong;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class getGBevaPageInfo {
    private String url;

    private StringBuffer getPageInfo() throws Exception {
        StringBuffer sb = new StringBuffer();
        String line;
        URL url = new URL(this.url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        InputStream is = httpURLConnection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
        while ((line = br.readLine()) != null) {
            sb.append(line + "\n");
        }
        return sb;
    }

    public getGBevaPageInfo() {
    }

    public getGBevaPageInfo(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static void main(String[] args) throws Exception {
        //main method
        getGBevaPageInfo getGBevaPageInfo = new getGBevaPageInfo("http://g.beva.com/kan-erge/c10108.html");
        System.out.println(getGBevaPageInfo.getPageInfo().toString());
    }
}
