package knowledge.baseKnowledge.javaXML;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

/**
 * @project: knowledge.baseKnowledge.javaXML
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/09 15:36
 **/
public class xpathDemo {
    private static void getChildNodes(Element elem) {
        System.out.println(elem.getName());
        Iterator<Node> it = elem.nodeIterator();
        while (it.hasNext()) {
            Node node = it.next();
            if (node instanceof Element) {
                Element e1 = (Element) node;
                getChildNodes(e1);
            }

        }
    }

    public static void main(String[] args) throws Exception {
        //main function.
        Document document = new SAXReader().read(new File("G:\\info\\NLPS_Code_Repos\\git\\LeetCode\\src\\knowledge\\baseKnowledge\\javaXML\\handlers-manager.xml"));
        Element element = document.getRootElement();
        //System.out.println() from template!
        System.out.println(element.getName());
        //System.out.println() from template!
        System.out.println("========================");
        List<Element> list = element.elements();
        for (Element element1 : list) {
            //System.out.println() from template!
            System.out.println(element1.getName());
        }
        System.out.println("========================");
        Element contactElem = element.element("contact");
        List<Element> contactList = contactElem.elements();
        for (Element element1 : contactList) {
            //System.out.println() from template!
            System.out.println(element1.getName());
        }
        System.out.println("========================");
        getChildNodes(element);
        System.out.println("========================");
        Element eee = element.element("contact");
        //System.out.println() from template!
        System.out.println(eee.getName());
        String xpath = "";
        //* 1.      /      绝对路径      表示从xml的根位置开始或子元素（一个层次结构）
        xpath = "/contactList/*";
        String xpathL1 = "/contactList/*";
        //2. //     相对路径       表示不分任何层次结构的选择元素。 xpath="//contact"
        //3. *      通配符         表示匹配所有元素
        xpath = "/contactList/*"; //根标签contactList下的所有子标签
        xpath = "/contactList//*";//根标签contactList下的所有标签（不分层次结构）
        // * 4. []      条件           表示选择什么条件下的元素
        //带有id属性的contact标签
        xpath = "//contact[@id]";
        //第二个的contact标签
        xpath = "//contact[2]";
        //选择最后一个contact标签
        xpath = "//contact[last()]";

        /**
         * 5. @     属性            表示选择属性节点
         */
        xpath = "//@id"; //选择id属性节点对象，返回的是Attribute对象
        xpath = "//contact[not(@id)]";//选择不包含id属性的contact标签节点
        xpath = "//contact[@id='002']";//选择id属性值为002的contact标签
        xpath = "//contact[@id='001' and @name='eric']";//选择id属性值为001，且name属性为eric的contact标签

        /**
         *6.  text()   表示选择文本内容
         */
        //选择name标签下的文本内容，返回Text对象
        xpath = "//name/text()";
        xpath = "//contact/name[text()='张三']";//选择姓名为张三的name标签
//        List<Node> list=document.selectNodes(xpath);
//        for (Node node:list){
//            //System.out.println() from template!
//            System.out.println(node);
//        }
//        FileOutputStream outputStream=new FileOutputStream("G:\\info\\NLPS_Code_Repos\\git\\LeetCode\\src\\knowledge\\baseKnowledge\\javaXML\\handlers-manager-demo.xml");
//        OutputFormat format=OutputFormat.createPrettyPrint();
//        format.setEncoding("utf-8");
//        XMLWriter writer=new XMLWriter(outputStream,format);
//        writer.write(document);
//        writer.close();

    }
}
