package tools.YamlFormat.json2Yaml;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * @project: tools.YamlFormat.json2Yaml
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/11 17:25
 **/
public class Json2Yaml {
    public static void main(String[] args) {
        try (Reader reader = new InputStreamReader(Json2Yaml.class.getClassLoader().getResourceAsStream("./tools/YamlFormat/json2Yaml/example1.json"))) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Type type = new TypeToken<Map<String, Object>>() {
            }.getType();
            Map<String, Object> fromJson = gson.fromJson(reader, type);
            System.out.println(fromJson);

            Yaml yaml = new Yaml();
            System.out.println(yaml.dumpAsMap(fromJson));
//            Map<String, Object> map = (Map<String, Object>)yaml.load(fromJson);
//            System.out.println(map);
//            System.out.println(gson.toJson(map));
        } catch (IOException ioEx) {
            throw new RuntimeException(ioEx);
        }


//        Yaml yaml = new Yaml();
//        //System.out.println() from template!
////        System.out.println(Json2Yaml.class.getClassLoader().getResourceAsStream(""));
//        try (InputStream is = Json2Yaml.class.getClassLoader().getResourceAsStream("./tools/YamlFormat/json2Yaml/example1.json")) {
//            Map<String, Object> map = (Map<String, Object>)yaml.load(is);
//            System.out.println(map);
//            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//            System.out.println(gson.toJson(map));
//        } catch (IOException ioEx) {
//            throw new RuntimeException(ioEx);
//        }
    }
}
