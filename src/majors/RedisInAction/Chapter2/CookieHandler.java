package majors.RedisInAction.Chapter2;

import majors.RedisInAction.Chapter1.JedisProvider;
import redis.clients.jedis.Jedis;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/05/02 10:50
 **/
public class CookieHandler {
    private Jedis jedis;
    private static boolean QUIT = false;
    private final static int LIMIT = 1000000;

    public CookieHandler(Jedis jedis) {
        this.jedis = jedis;
    }

    //    Jedis jedis= JedisProvider.getJedis();
    public String checkToken(String token) {
        return this.jedis.hget("login:", token);
    }

    public void updateToken(String token, String user, String item) {
        Long timeNow = System.currentTimeMillis();
        this.jedis.hset("login:", token, user);
        this.jedis.zadd("recent:", timeNow, token);
        this.jedis.zadd("viewed:" + token, timeNow, item);
        this.jedis.zremrangeByRank("viewed:" + token, 0, -26);
    }

    public void updateToken(String token, String user) {
        Long timeNow = System.currentTimeMillis();
        this.jedis.hset("login:", token, user);
        this.jedis.zadd("recent:", timeNow, token);
    }

    public void cleanSession() throws InterruptedException {
        while (QUIT) {
            int size = this.jedis.zcard("recent:").intValue();
            if (size < LIMIT) {
                Thread.sleep(1);
                continue;
            }
            int endIndex = Math.min(size - LIMIT, 100);
            Set<String> token = this.jedis.zrange("recent:", 0, endIndex);
            Set<String> set = null;
            for (String s : token) {
                set.add("viewed:" + s);

            }
            this.jedis.del(set.toArray(new String[set.size()]));
            this.jedis.hdel("login:", token.toArray(new String[token.size()]));
            this.jedis.zrem("recent:", token.toArray(new String[token.size()]));

        }
    }
}
