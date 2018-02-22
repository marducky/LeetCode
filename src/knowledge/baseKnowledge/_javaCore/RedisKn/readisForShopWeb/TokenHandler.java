package knowledge.baseKnowledge._javaCore.RedisKn.readisForShopWeb;

import redis.clients.jedis.Jedis;

/**
 * @project: knowledge.baseKnowledge._javaCore.RedisKn.readisForShopWeb
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/22 13:20
 **/

/**
 * 使用Redis重新实现登录cookie，取代目前由关系型数据库实现的登录cookie功能
 * 1、将使用一个散列来存储登录cookie令牌与与登录用户之间的映射。
 * 2、需要根据给定的令牌来查找与之对应的用户，并在已经登录的情况下，返回该用户id。
 */
public class TokenHandler {
    /**
     * 使用Redis重新实现登录cookie，取代目前由关系型数据库实现的登录cookie功能
     * 1、将使用一个散列来存储登录cookie令牌与与登录用户之间的映射。
     * 2、需要根据给定的令牌来查找与之对应的用户，并在已经登录的情况下，返回该用户id。
     */
    public String checkToken(Jedis conn, String token) {
        //1、String token = UUID.randomUUID().toString();
        //2、尝试获取并返回令牌对应的用户
        return conn.hget("login:", token);
    }

    /**
     * 1、每次用户浏览页面的时候，程序需都会对用户存储在登录散列里面的信息进行更新，
     * 2、并将用户的令牌和当前时间戳添加到记录最近登录用户的集合里。
     * 3、如果用户正在浏览的是一个商品，程序还会将商品添加到记录这个用户最近浏览过的商品有序集合里面，
     * 4、如果记录商品的数量超过25个时，对这个有序集合进行修剪。
     */
    public void updateToken(Jedis conn, String token, String user, String item) {
        //1、获取当前时间戳
        long timestamp = System.currentTimeMillis() / 1000;
        //2、维持令牌与已登录用户之间的映射。
        conn.hset("login:", token, user);
        //3、记录令牌最后一次出现的时间
        conn.zadd("recent:", timestamp, token);
        if (item != null) {
            //4、记录用户浏览过的商品
            conn.zadd("viewed:" + token, timestamp, item);
            //5、移除旧记录，只保留用户最近浏览过的25个商品
            conn.zremrangeByRank("viewed:" + token, 0, -26);
            //6、为有序集key的成员member的score值加上增量increment。通过传递一个负数值increment 让 score 减去相应的值，
            conn.zincrby("viewed:", -1, item);
        }
    }
}
