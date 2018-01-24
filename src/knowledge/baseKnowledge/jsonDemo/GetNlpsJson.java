package knowledge.baseKnowledge.jsonDemo;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import tools.getHandler.PrintConsoleInfo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//class manager{
//    private String nlus;
//}
public class GetNlpsJson {
    private static int conut = 0;
    public void getNlpsJson() {
        XmlToJson jsonToXml = new XmlToJson();
        String pathXMl = "C:\\Users\\neng.qi\\Desktop\\handlers-manager.xml";
        String allXmlToJson = jsonToXml.xmlStringTojson(jsonToXml.xmlToString(pathXMl));
        String changeClassToClassDetailAllXMlToJson = allXmlToJson.replace("\"class\"", "\"class_detail\"");

//        System.out.println(allXmlToJson);
//        JSONArray jsonArray=JSONArray.fromObject(allXmlToJson);
        JSONObject jsonObject = JSONObject.fromObject(changeClassToClassDetailAllXMlToJson);
        ConfDemo confDemo = new ConfDemo();
        confDemo.setConfAll(jsonObject.getString("manager"));
//        System.out.println(confDemo.getConfAll());
        ManagerDemo managerDemo = new ManagerDemo();
        JSONObject jsonObject1 = JSONObject.fromObject(confDemo.getConfAll());
//        ManagerDemo managerDemo=(ManagerDemo) JSONObject.toBean(jsonObject,ManagerDemo.class);
        managerDemo.setNlus_use(jsonObject1.getString("use-nlus"));
        managerDemo.setNlusList(jsonObject1.getJSONArray("nlus"));
//        System.out.println(managerDemo.getNlusList().get(1));
        int flag_nlps_v2 = 0;
        for (int i = 0; i < managerDemo.getNlusList().size(); i++) {
            JSONObject jsonObject2 = JSONObject.fromObject(managerDemo.getNlusList().get(i));
            NlusDemo nlusDemo = new NlusDemo();
            nlusDemo.setName(jsonObject2.getString("name"));
//            System.out.println(nlusDemo.getName());
            if (nlusDemo.getName().trim().equals("nlps_v2")) {
                flag_nlps_v2 = i;
                break;
            }
        }
        JSONObject jsonObject3 = JSONObject.fromObject(managerDemo.getNlusList().get(flag_nlps_v2));
        //nlps_v2 begin.
        NlusDemo nlusDemo = new NlusDemo();
        nlusDemo.setName(jsonObject3.getString("name"));
        nlusDemo.setNluDemoList(jsonObject3.getJSONArray("nlu"));
        nlusDemo.setNlusDemoList(jsonObject3.getJSONArray("nlus"));
        nlusDemo.setNluGroupDempList(jsonObject3.getJSONArray("nlu-group"));
        //begin the nludetail
        Map<String, String> nlu_map = new HashMap<String, String>();
        for (int i = 0; i < nlusDemo.getNluDemoList().size(); i++) {
            NluDemo nluDemo = new NluDemo();
            JSONObject jsonObject4 = JSONObject.fromObject(nlusDemo.getNluDemoList().get(i));
            nluDemo.setClass_detail(jsonObject4.getString("class_detail"));
            nluDemo.setName(jsonObject4.getString("name"));
            nlu_map.put(jsonObject4.getString("name"), jsonObject4.getString("class_detail"));
//            map.put(jsonObject4.getString("name"),"ssss");
//            System.out.println(nluDemo.getName());
        }
//        for (String s : nlu_map.keySet()) {
//            System.out.println(s + ": " + "\n" + nlu_map.get(s));
//        }
//        System.out.println(map.toString());
        //begin the nlu-group
        Map<String, Map<String, String>> map_nlu_group_map_nlu = new HashMap<String, Map<String, String>>();
        for (int i = 0; i < nlusDemo.getNluGroupDempList().size(); i++) {
            NluGroupDemo nluGroupDemo = new NluGroupDemo();
            JSONObject jsonObject5 = JSONObject.fromObject(nlusDemo.getNluGroupDempList().get(i));
            nluGroupDemo.setNluDemos(jsonObject5.getJSONArray("nlu"));
            Map<String, String> map_nlu_group_nlu = new HashMap<String, String>();
            for (int j = 0; j < nluGroupDemo.getNluDemos().size(); j++) {
//                NluDemo nluDemo=new NluDemo();
                JSONObject jsonObject6 = JSONObject.fromObject(nluGroupDemo.getNluDemos().get(j));
                map_nlu_group_nlu.put(jsonObject6.getString("name"), jsonObject6.getString("class_detail"));
            }
            map_nlu_group_map_nlu.put(jsonObject5.getString("condition-class"), map_nlu_group_nlu);
        }
        for (String s : map_nlu_group_map_nlu.keySet()) {
//            System.out.println(s + ": " + "\n" +map_nlu_group_map_nlu.get(s));
//            System.out.println(s + ": ");
            for (String ss : map_nlu_group_map_nlu.get(s).keySet()) {
                System.out.println(ss + ": " + "\n" + map_nlu_group_map_nlu.get(s).get(ss));
                nlu_map.put("nlu_group:" + s + "nlu: " + ss, map_nlu_group_map_nlu.get(s).get(ss));
            }
        }
        for (String s : nlu_map.keySet()) {
            System.out.println(s + ": " + "\n" + nlu_map.get(s));
        }
        System.out.println(nlu_map.size());
//
    }

    public static void main(String[] args) {
        GetNlpsJson getNlpsJson = new GetNlpsJson();
        getNlpsJson.getNlpsJson();
        PrintConsoleInfo printConsoleInfo = new PrintConsoleInfo();
        printConsoleInfo.printConsoleInfoWithClear();
    }
}
