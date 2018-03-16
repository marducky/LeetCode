package knowledge.baseKnowledge._javaCore.httpClientForMultiProcess;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.*;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/03/16 13:12
 **/
public class httpClientForMultiProcess {
    public static String get(String url) {
        CloseableHttpResponse response = null;
        BufferedReader in = null;
        String result = "";
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            response = httpclient.execute(httpGet);

//            in = new BufferedReader(new InputStreamReader(response));
            in = new BufferedReader(new InputStreamReader(new FileInputStream(new File(""))));
            StringBuffer sb = new StringBuffer("");
            String line = "";
            String NL = System.getProperty("line.separator");
            while ((line = in.readLine()) != null) {
                sb.append(line + NL);
            }
            in.close();
            result = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != response) response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
