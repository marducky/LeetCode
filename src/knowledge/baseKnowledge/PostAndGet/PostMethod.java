/**
 * post请求：POST是向服务器端发送数据的，但是该请求会改变数据的种类等资源，就像数据库的insert操作一样，会创建新的内容。几乎目前所有的提交操作都是用POST请求的。
 *
 * @param StrURL
 * @param params
 * @return
 */
package knowledge.baseKnowledge.PostAndGet;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;


public class PostMethod {
    public static String jsonPost(String strURL, Map<String, String> params) {
        try {
            URL url = new URL(strURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.connect();
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
//            out.append()
//            out.append(JSONUtil.object2JsonString(params));
//            out.flush();
//            out.close();
//
//            int code = connection.getResponseCode();
//            InputStream is = null;
//            if (code == 200) {
//                is = connection.getInputStream();
//            } else {
//                is = connection.getErrorStream();
//            }
//
//            // 读取响应
//            int length = (int) connection.getContentLength();// 获取长度
//            if (length != -1) {
//                byte[] data = new byte[length];
//                byte[] temp = new byte[512];
//                int readLen = 0;
//                int destPos = 0;
//                while ((readLen = is.read(temp)) > 0) {
//                    System.arraycopy(temp, 0, data, destPos, readLen);
//                    destPos += readLen;
//                }
//                String result = new String(data, "UTF-8"); // utf-8编码
//                return result;
//            }
//
//        } catch (IOException e) {
//            LOG.error("Exception occur when send http post request!", e);
//        }
//        return "error"; // 自定义错误信息
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "sss";
        //TODO:upload the JSON PACKAGE.
    }

}
