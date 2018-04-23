package majors.RedisInAction.Chapter1;

import java.util.HashSet;
import java.util.Set;

public class test {
    public static void main(String[] args) {
        //main method
        Set<String> strings = new HashSet<>();
        strings.add("222");
        strings.add("333");
        Goods goods = new Goods();
        goods.setId(1111);
        goods.setPrice(22);
        goods.setTitle("22222");
        goods.setTags(strings);
        System.out.println(goods.toString());
    }
}
