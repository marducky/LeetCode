package knowledge.baseKnowledge._javaCore.URLorURI;

import java.net.URI;

/**
 * @project: knowledge.baseKnowledge._javaCore.URLorURI
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/12 15:12
 **/
public class URIJavaTest {
    public static void main(String[] args) throws Exception {
        //main function.
        URI uri = new URI("http://www.oracle.com/technetwork/cn/java/javase/documentation/api-jsp-136079-zhs.html");
        //System.out.println() from template!
        System.out.println("scheme             : " + uri.getScheme());
        System.out.println("SchemeSpecificPart : " + uri.getSchemeSpecificPart());
        System.out.println("Authority          : " + uri.getAuthority());
        System.out.println("host               : " + uri.getHost());
        System.out.println("port               : " + uri.getPort());
        System.out.println("path               : " + uri.getPath());
        System.out.println("query              : " + uri.getQuery());
        System.out.println("fragment           : " + uri.getFragment());
    }
}
