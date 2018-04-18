package majors.openSource.youban.java.handler;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetYouBanPageInfoHandler {
    private String perUrl;

    public GetYouBanPageInfoHandler(String perUrl) {
        this.perUrl = perUrl;
    }

    public StringBuffer getPageInfo() throws Exception {
        StringBuffer sb = new StringBuffer();
        String line;
        URL url = new URL(this.perUrl);
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

}
