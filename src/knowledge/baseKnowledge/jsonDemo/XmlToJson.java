/**
 * commons-beanutils-1.8.0.jar不加这个包
 * java.lang.NoClassDefFoundError: org/apache/commons/beanutils/DynaBean
 * commons-collections.jar 不加这个包
 * java.lang.NoClassDefFoundError: org/apache/commons/collections/map/ListOrderedMap
 * commons-lang-2.4.jar不加这个包
 * java.lang.NoClassDefFoundError: org/apache/commons/lang/exception/NestableRuntimeException
 * commons-logging-1.1.1.jar不加这个包
 * java.lang.NoClassDefFoundError: org/apache/commons/logging/LogFactory
 * ezmorph-1.0.6.jar不加这个包
 * java.lang.NoClassDefFoundError: net/sf/ezmorph/Morpher
 * json-lib-2.4-jdk15.jar不加这个包
 * java.lang.NoClassDefFoundError: net/sf/json/JSONObject
 * 相应jar包可到网上下载，也可以用下面提供的！
 */
package knowledge.baseKnowledge.jsonDemo;

import org.json.JSONObject;
import org.json.XML;
//import net.sf.json.JSONObject;
//import net.sf.json.JSONArray;


import java.io.*;

public class XmlToJson {
    public String xmlToString(String xmlPath) {
        File file = new File(xmlPath);
        String resString = "";
        if (file.isFile() && file.exists()) {

            try {
                InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuffer stringBuffer = new StringBuffer();
                String res = null;
                while ((res = bufferedReader.readLine()) != null) {
                    stringBuffer.append(res);
                }
                inputStreamReader.close();
                resString = stringBuffer.toString();
//                return stringBuffer.toString();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return resString;
    }

    public String xmlStringTojson(String xml) {
        JSONObject xmlJSONObj = XML.toJSONObject(xml);
        String jsonPrettyPrintString = xmlJSONObj.toString(4);
//        System.out.println(jsonPrettyPrintString);
        return jsonPrettyPrintString;
    }

    public static void main(String[] args) {
        String pathXMl = "C:\\Users\\neng.qi\\Desktop\\handlers-manager.xml";
        XmlToJson jsonToXml = new XmlToJson();
//        jsonToXml.xmlToString(pathXMl);
//        jsonToXml.xmlTojson()
        jsonToXml.xmlStringTojson(jsonToXml.xmlToString(pathXMl));
    }


}
