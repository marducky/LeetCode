package knowledge.baseKnowledge.jsonDemo;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

//class manager{
//    private String nlus;
//}
public class GetNlpsJson {
    public void getNlpsJson() {
        XmlToJson jsonToXml = new XmlToJson();
        String pathXMl = "C:\\Users\\neng.qi\\Desktop\\handlers-manager.xml";
        String allXmlToJson = jsonToXml.xmlStringTojson(jsonToXml.xmlToString(pathXMl));
//        JSONArray jsonArray=JSONArray.fromObject(allXmlToJson);
        JSONObject jsonObject = JSONObject.fromObject(allXmlToJson);
//        ManagerDemo managerDemo=new ManagerDemo();
////        ManagerDemo managerDemo=(ManagerDemo) JSONObject.toBean(jsonObject,ManagerDemo.class);
//        managerDemo.setNlus_use(jsonObject.getString("use-nlus"));
//        managerDemo.setNlusList(jsonObject.getJSONArray("nlus"));
//        System.out.println(managerDemo.getNlusList());
        ConfDemo confDemo = new ConfDemo();
        confDemo.setConfAll(jsonObject.getString("manager"));
        System.out.println(confDemo.getConfAll());
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


//        System.out.println(flag_nlps_v2);
//        for (NlusDemo nlusDemo:managerDemo.getNlusList()){
////            System.out.println(nlusDemo.toString());
//            System.out.println("======================");
//        }
//        JSONObject xmlJSONObj = XML.toJSONObject(jsonToXml.xmlToString(pathXMl));
    }

    public static void main(String[] args) {
        GetNlpsJson getNlpsJson = new GetNlpsJson();
        getNlpsJson.getNlpsJson();
    }
}
