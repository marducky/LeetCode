package majors.RedisInAction.RedisPlusMysql.controller;

import majors.RedisInAction.RedisPlusMysql.model.LogClassForRedis;
import redis.clients.jedis.Jedis;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/05/10 12:30
 **/
public class RedisController {
    public void addToRedisSort(Jedis jedis, LogClassForRedis logClassForRedis) {
        jedis.zadd("log_redis", Long.valueOf(logClassForRedis.getLog_time()), logClassForRedis.getLog_info());
    }
}
