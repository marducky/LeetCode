package majors.openSource.Generate2Word;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.IOException;
import java.util.List;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/04/23 17:45
 **/

public class ReadParamHandler {
    //模板文件地址
    private static String inputUrl = "C:\\Users\\zhihe\\Desktop\\demo\\001.docx";

    public void runTest() {

        try {
            //解析docx模板并获取document对象
            XWPFDocument document = new XWPFDocument(POIXMLDocument.openPackage(inputUrl));
            //获取整个文本对象
            List<XWPFParagraph> allParagraph = document.getParagraphs();

            //获取XWPFRun对象输出整个文本内容
            StringBuffer tempText = new StringBuffer();
            for (XWPFParagraph xwpfParagraph : allParagraph) {
                List<XWPFRun> runList = xwpfParagraph.getRuns();
                for (XWPFRun xwpfRun : runList) {
                    tempText.append(xwpfRun.toString());
                }
            }
            System.out.println(tempText.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
