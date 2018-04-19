package majors.RedisInAction.Chapter1;

import redis.clients.jedis.Jedis;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/04/19 17:21
 **/
public class CallRedis {

    public static void step1() {
        Jedis jedis = new Jedis("localhost");
        jedis.set("hello", "world");
        jedis.del("hello");
        System.out.println(jedis.get("hello"));
    }

    public static void step2() {
        Jedis jedis = new Jedis("localhost");
        jedis.lpush("janus", "1", "2", "3");
        System.out.println(jedis.lindex("janus", 1));
    }

    public static void main(String[] args) {
        step2();

    }
}
