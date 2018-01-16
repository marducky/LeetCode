package knowledge.baseKnowledge.jsonDemo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonDemo {
    private static void ParseJson(String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);
        System.out.println(jsonObject.get("name"));
    }

    private static void CreateJson() throws JSONException {
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("name", "Alexia");
        map1.put("sex", "female");
        map1.put("age", "23");
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("name", "Edward");
        map2.put("sex", "male");
        map2.put("age", "24");
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(map1);
        jsonArray.put(map2);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("List", jsonArray);
        jsonObject.put("Count", "1200");
        System.out.println(jsonObject.toString());
    }

    private static void StringJson() {
        JSONObject object = new JSONObject();
        Object nullObj = null;
        try {
            object.put("name", "Janus");
            object.put("sex", "male");
            object.put("age", 23);
            System.out.println(object.toString());
            JSONObject jsonObjec = new JSONObject();
            jsonObjec.put("info", object);
            jsonObjec.put("description", "default");
            System.out.println(jsonObjec.get("info"));
        } catch (JSONException e) {
            e.printStackTrace();

        }
    }

    private static void MapJson() {
        Object nullObj = null;
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "Janus");
        map.put("age", "23");
        map.put("address", "Chengdu");
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(map);
        System.out.println(jsonArray.get(0));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("List", jsonArray);
        System.out.println(jsonObject.get("List"));
    }

    public static void main(String[] args) throws JSONException {
//        ParseJson("{\"name\":\"Alexia\",\"age\":\"23\"}");
//        CreateJson();
        StringJson();
//        MapJson();
    }
}
