package tools.getHandler.ggggoooInfo;

import net.sf.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/03/13 12:31
 **/
public class Request2Nina {

    private static ArrayList<String> readFileContent(String filePath, String fileName) {
        if (!filePath.endsWith("/")) {
            filePath += "/";
        }
        ArrayList<String> result = new ArrayList<String>();
        File file = new File(filePath + fileName);
        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            String line = "";
            BufferedReader br = new BufferedReader(isr);
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
            fis.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static JSONObject requestNina(String url, String param) {
        PrintWriter outq = null;
        JSONObject jsonObject = null;
        BufferedReader in = null;

        String result = "";
        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            HttpURLConnection httpUrlConnection = (HttpURLConnection) conn;
            httpUrlConnection.setRequestProperty("Content-Type", "application/json");
            httpUrlConnection.setDoOutput(true);
            httpUrlConnection.setDoInput(true);
            outq = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
            outq.print(param);
            outq.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            jsonObject = JSONObject.fromObject(result);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outq != null) {
                    outq.close();
                    int i = 0;
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return jsonObject;
    }

}
