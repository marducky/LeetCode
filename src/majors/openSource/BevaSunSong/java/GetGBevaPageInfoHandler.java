package majors.openSource.BevaSunSong.java;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetGBevaPageInfoHandler {
    private String url;

    public StringBuffer getPageInfo() throws Exception {
        StringBuffer sb = new StringBuffer();
        String line;
        URL url = new URL(this.url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        InputStream is = httpURLConnection.getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
        while ((line = br.readLine()) != null) {
            sb.append(line + "\n");
        }
//        is.close();
//        br.close();
        return sb;
    }

    public GetGBevaPageInfoHandler(String url) {
        this.url = url;
        try {
            StringBuffer sb = getPageInfo();
//            System.out.println(sb.toString());
            new Write2FileHandler(this.url.substring(url.lastIndexOf("/"), url.length()), sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
//        String url="http://g.beva.com/kan-erge/c10108.html";
        String url1 = "http://g.beva.com/kan-erge--c10106.html";
        //main method
//        GetGBevaPageInfoHandler getGBevaPageInfo = new GetGBevaPageInfoHandler("http://g.beva.com/kan-erge/c10108.html");
//        System.out.println(getGBevaPageInfo.getPageInfo().toString());
        new GetGBevaPageInfoHandler(url1);
    }
}
