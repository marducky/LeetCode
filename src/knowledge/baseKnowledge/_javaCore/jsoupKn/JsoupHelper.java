package knowledge.baseKnowledge._javaCore.jsoupKn;

//import com.sun.xml.internal.txw2.output.DomSerializer;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import javax.xml.xpath.XPathConstants;
import java.io.IOException;

/**
 * @project: knowledge.baseKnowledge._javaCore.jsoupKn
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/09 16:40
 **/

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.DomSerializer;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class JsoupHelper {

    public static Object fecthNode(String url, String xpath) throws Exception {
        String html = null;
        try {
            Connection connect = Jsoup.connect(url);
            html = connect.get().body().html();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        HtmlCleaner hc = new HtmlCleaner();
        TagNode tn = hc.clean(html);
        Document dom = new org.htmlcleaner.DomSerializer(new CleanerProperties()).createDOM(tn);
        XPath xPath = XPathFactory.newInstance().newXPath();

        Object result = xPath.evaluate(xpath, dom, XPathConstants.NODESET);

        return result;
    }
}

/**
 * 获取xpath下的a标签的文本值及href属性值
 * /**
 * public static Map<String, String> fecthByMap(String url, String xpath) throws Exception {
 * Map<String, String> nodeMap = new LinkedHashMap<>();
 * <p>
 * Object result = fecthNode(url, xpath);
 * <p>
 * if (result instanceof NodeList) {
 * NodeList nodeList = (NodeList) result;
 * <p>
 * for (int i = 0; i < nodeList.getLength(); i++) {
 * Node node = nodeList.item(i);
 * if(node == null){
 * continue;
 * }
 * nodeMap.put(node.getTextContent(), node.getAttributes().getNamedItem("href")!=null ?
 * node.getAttributes().getNamedItem("href").getTextContent() : "");
 * <p>
 * System.out.println(node.getTextContent() + " : " + node.getAttributes().getNamedItem("href"));
 * }
 * }
 * <p>
 * return nodeMap;
 * }
 * /**
 * 获取xpath下的某个属性值
 * /**
 * public static List<String> fecthAttr(String url, String xpath, String attr) throws Exception {
 * List<String> list = new ArrayList<>();
 * <p>
 * Object result = fecthNode(url, xpath);
 * <p>
 * if (result instanceof NodeList) {
 * NodeList nodeList = (NodeList) result;
 * <p>
 * for (int i = 0; i < nodeList.getLength(); i++) {
 * Node node = nodeList.item(i);
 * if(node == null){
 * continue;
 * }
 * list.add(node.getAttributes().getNamedItem(attr).getTextContent());
 * <p>
 * //System.out.println(node.getTextContent() + " : " + node.getAttributes().getNamedItem("href"));
 * }
 * }
 * <p>
 * return list;
 * }
 * <p>
 * 作者：测试开发栈
 * 链接：https://www.jianshu.com/p/5f9492e81198
 * 來源：简书
 * //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处
 */