package knowledge.baseKnowledge._javaCore.foreach;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/03/14 10:54
 **/
public class ForeachListDemo1 {
    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
        items.add("A");
        items.add("B");
        items.add("C");
        items.add("D");
        items.add("E");

//lambda
//Output : A,B,C,D,E
        items.forEach(item -> System.out.println(item));

//Output : C
        items.forEach(item -> {
            if ("C".equals(item)) {
                System.out.println(item);
            }
        });

//method reference
//Output : A,B,C,D,E
        items.forEach(System.out::println);

//Stream and filter
//Output : B
        items.stream()
                .filter(s -> s.contains("B"))
                .forEach(System.out::println);

    }
}
