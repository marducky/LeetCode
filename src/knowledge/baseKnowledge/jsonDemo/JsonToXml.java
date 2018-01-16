package knowledge.baseKnowledge.jsonDemo;

import org.json.JSONObject;
import org.json.XML;

import java.io.*;

public class JsonToXml {
    private static String xmlToString(String xmlPath) {
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

    private static void jsonToXml(String xml) {
        JSONObject xmlJSONObj = XML.toJSONObject(xml);
        String jsonPrettyPrintString = xmlJSONObj.toString(4);
        System.out.println(jsonPrettyPrintString);
    }

    public static void main(String[] args) {
        String pathXMl = "C:\\Users\\neng.qi\\Desktop\\handlers-manager.xml";
        jsonToXml(xmlToString(pathXMl));
    }
}
