package tools.YamlFormat.yaml2Json;

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
 * @project: tools.YamlFormat.yaml2Json
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/11 17:21
 **/
//https://github.com/marcingolenapsik/json2yaml
public class Yaml2Json {
    public static void main(String[] args) {
        Yaml yaml = new Yaml();
        try (InputStream is = Yaml2Json.class.getClassLoader().getResourceAsStream("./tools/YamlFormat/yaml2Json/mysql-rc.yaml")) {
            Map<String, Object> map = (Map<String, Object>) yaml.load(is);
            System.out.println(map);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println(gson.toJson(map));
        } catch (IOException ioEx) {
            throw new RuntimeException(ioEx);
        }


//        try (Reader reader = new InputStreamReader(Yaml2Json.class.getClassLoader().getResourceAsStream("tools/YamlFormat/yaml2Json/example1.yaml"))) {
//            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//            Type type = new TypeToken<Map<String, Object>>(){}.getType();
//            Map<String, Object> fromJson = gson.fromJson(reader, type);
//            System.out.println(fromJson);
//
//            Yaml yaml = new Yaml();
//            System.out.println(yaml.dumpAsMap(fromJson));
////            Map<String, Object> map = (Map<String, Object>)yaml.load(fromJson);
////            System.out.println(map);
////            System.out.println(gson.toJson(map));
//        } catch (IOException ioEx) {
//            throw new RuntimeException(ioEx);
//        }
    }
}
