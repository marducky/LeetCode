package majors.RedisInAction.Chapter2;

import redis.clients.jedis.Jedis;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/05/02 15:15
 **/
public class CartHandler {
    private Jedis jedis;

    public CartHandler(Jedis jedis) {
        this.jedis = jedis;
    }

    public boolean add2Cart(String session, String item, int count) {
        if (count <= 0) {
            this.jedis.hdel("cart:" + session, item);
            return false;
        } else {
            this.jedis.hset("cart:" + session, item, Integer.toString(count));
            return true;
        }
    }
}
