package tools.getHandler.ccccoooInfo;

import net.sf.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class SendNinaUseCasesPostForStubby {
    /**
     * @param pathName
     * @return
     */
    private ArrayList<String> getPostJsonModule(String pathName) {
        File file = new File(pathName + "\\PostJsonForStuby.txt");
        ArrayList<String> arrayListPost = new ArrayList<String>();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = "";
            boolean nextPostFlag = false;
            StringBuffer stringBuffer = null;
            String sssSavePsot = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.startsWith("###") && stringBuffer != null) {
                    sssSavePsot = stringBuffer.toString();
                    arrayListPost.add(sssSavePsot);
                    stringBuffer = null;
                } else {
                    stringBuffer.append(line + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayListPost;
    }

    /**
     * @param arrayListPost
     * @param paName
     * @param userText
     * @return
     */
    private ArrayList<String> changePostFlag(ArrayList<String> arrayListPost, String paName, String userText) {
        //change {"PA_Service_Name":"pa_flag","UserText":"text_flag"}
        String pa_pattren = "\"pa_flag\"";
        ArrayList<String> arrayListReslut = new ArrayList<String>();
        for (String ssTemp : arrayListPost) {
            if (ssTemp.indexOf(pa_pattren) != -1) ;
            {
                ssTemp.replaceAll("pa_flag", paName);
                ssTemp.replaceAll("text_flag", userText);
                arrayListReslut.add(ssTemp);
            }
        }
        return arrayListReslut;
    }


    //get the json

    /**
     * @param arrayListPost
     * @param userText
     * @return
     */
    private ArrayList<String> changePostFlag(ArrayList<String> arrayListPost, String userText) {
        //change {"UserText":"text_flag"}
        String pa_pattren = "\"pa_flag\"";
        ArrayList<String> arrayListReslut = new ArrayList<String>();
        for (String ssTemp : arrayListPost) {
            if (ssTemp.indexOf(pa_pattren) == -1) ;
            {
                ssTemp.replaceAll("text_flag", userText);
                arrayListReslut.add(ssTemp);
            }
        }
        return arrayListReslut;
    }

    /**
     * @param url
     * @param param
     * @return
     */
    private JSONObject sendPostUrl(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        JSONObject jsonObject = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流（设置请求编码为UTF-8）
            out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 获取请求返回数据（设置返回数据编码为UTF-8）
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            jsonObject = JSONObject.fromObject(result);
            System.out.println(jsonObject);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
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

    public void sendPostToNinaUrl() {
        GetNinaUseCasesTwo getNinaUseCases = new GetNinaUseCasesTwo();
        ArrayList<String> postJsonArrayList = getPostJsonModule(getNinaUseCases.getFileName());
        //TODO: for Stubby Post!
    }

}
