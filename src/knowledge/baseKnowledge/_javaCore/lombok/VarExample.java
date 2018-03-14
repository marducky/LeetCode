package knowledge.baseKnowledge._javaCore.lombok;

import lombok.val;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/03/14 13:24
 **/
public class VarExample {
    public String example() {
        val example = new ArrayList<String>();
        example.add("Hello, World!");
        val foo = example.get(0);
        return foo.toLowerCase();
    }

    public void example2() {
        val map = new HashMap<Integer, String>();
        map.put(0, "zero");
        map.put(5, "five");
        for (val entry : map.entrySet()) {
            System.out.printf("%d: %s\n", entry.getKey(), entry.getValue()

            );
        }
    }

    public static void main(String[] args) {
        VarExample varExample = new VarExample();
        System.out.println(varExample.example());
        varExample.example2();
    }
}
