package knowledge.baseKnowledge._javaCore.foreach;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/03/14 10:45
 **/
public class ForeachMapDemo1 {
    public static void main(String[] args) {
        Map<String, Integer> items = new HashMap<String, Integer>();
        items.put("A", 1);
        items.put("B", 2);
        items.put("C", 3);
        items.put("D", 4);
        items.put("E", 5);
        items.put("F", 6);
        items.forEach((k, v) -> System.out.println("Item : " + k + " Count : " + v));
    }
}
