package knowledge.baseKnowledge._javaCore.RedisKn.shopWebCart;

/**
 * @project: knowledge.baseKnowledge._javaCore.RedisKn.shopWebCart
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/22 13:50
 **/
public class Inventory {
    private String id;
    private String data;
    private long time;

    private Inventory(String id) {
        this.id = id;
        this.data = "data to cache...";
        this.time = System.currentTimeMillis() / 1000;
    }

    public static Inventory get(String id) {
        return new Inventory(id);
    }
}