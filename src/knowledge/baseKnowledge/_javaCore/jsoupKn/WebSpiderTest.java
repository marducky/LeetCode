package knowledge.baseKnowledge._javaCore.jsoupKn;

//import org.jsoup.Document;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @project: knowledge.baseKnowledge._javaCore.jsoupKn
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/09 16:18
 * 百度百科：jsoup 是一款Java 版的HTML解析器，可直接解析某个URL地址、HTML文本内容。它提供了一套非常省力的API，可通过DOM，CSS以及类似于jQuery的操作方法来取出和操作数据。
 **/
public class WebSpiderTest {
    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

    private static void getArticle() throws IOException {
        String url = "https://www.jianshu.com";
        Document document = Jsoup.connect(url).get();
        Elements articleLinks = document.select("a[class=\"title\"]");
        //System.out.println() from template!
        print("\nLinks:(%d)", articleLinks.size());
        print("\nLinks:(%d)", articleLinks.size());
        System.out.print("\n Links: " + articleLinks.size());
        for (Element link : articleLinks) {
            //System.out.println() from template!
//            print("*a: <%s> "+link.attr("abs:href"));
            //System.out.println() from template!
            System.out.println(link.attr("abs:href"));
            //System.out.println() from template!
            System.out.println(link.text());

        }
    }

    public static void main(String[] args) throws IOException {
        //main function.
        //System.out.println() from template!
        getArticle();
    }
}
