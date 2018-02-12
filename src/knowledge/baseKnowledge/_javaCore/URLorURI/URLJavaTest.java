package knowledge.baseKnowledge._javaCore.URLorURI;

import java.net.URL;

/**
 * @project: knowledge.baseKnowledge._javaCore.URLorURI
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/12 15:17
 **/
public class URLJavaTest {
    public static void main(String[] args) throws Exception {
        //main function.
        URL url = new URL("http://www.oracle.com/technetwork/cn/java/javase/documentation/api-jsp-136079-zhs.html");
        System.out.println("URL：" + url.toString());
        System.out.println("protocol：" + url.getProtocol());
        System.out.println("authority：" + url.getAuthority());
        System.out.println("filename：" + url.getFile());
        System.out.println("host：" + url.getHost());
        System.out.println("path：" + url.getPath());
        System.out.println("port：" + url.getPort());
        System.out.println("defaultport：" + url.getDefaultPort());
        System.out.println("query：" + url.getQuery());
        System.out.println("ref：" + url.getRef());
    }
}
