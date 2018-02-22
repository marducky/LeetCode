package knowledge.baseKnowledge._javaCore.RedisKn;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @project: knowledge.baseKnowledge._javaCore.RedisKn
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/22 13:55
 **/
public class TestRedis {


    private static void testConn() {
        Jedis jedis = new Jedis("localhost");
        System.out.println("Success!");
        System.out.println("Running: " + jedis.ping());
    }

    private static void testSetKey(String key, String value) {
        Jedis jedis = new Jedis("localhost");
        jedis.set(key, value);
        System.out.println("redis 存储的字符串为: " + jedis.get(key));
    }

    public static void main(String[] args) {
        testConn();
        testSetKey("Nuance", "yintaiin1199");

    }

    @Test
    public void testList() {
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //存储数据到列表中
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0, 2);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("列表项为: " + list.get(i));
        }
    }

    @Test
    public void testKeys() {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");

        // 获取数据并输出
        Set<String> keys = jedis.keys("*");
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            String key = it.next();
            System.out.println(key);
        }
    }
}
