package knowledge.baseKnowledge._javaCore.RedisKn.readisForShopWeb;

import redis.clients.jedis.Jedis;

/**
 * @project: knowledge.baseKnowledge._javaCore.RedisKn.readisForShopWeb
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/22 13:36
 **/
public class CacheLineHandler {
    /**
     * 为了应对促销活动带来的大量负载，需要对数据行进行缓存，具体做法是：
     * 1、编写一个持续运行的守护进程，让这个函数指定的数据行缓存到redis里面，并不定期的更新。
     * 2、缓存函数会将数据行编码为JSON字典并存储在Redis字典里。其中数据列的名字会被映射为JSON的字典，
     * 而数据行的值则被映射为JSON字典的值。
     * -----------------------------------------------------------------------------------------
     * 程序使用两个有序集合来记录应该在何时对缓存进行更新：
     * 1、第一个为调用有序集合，他的成员为数据行的ID，而分支则是一个时间戳，
     * 这个时间戳记录了应该在何时将指定的数据行缓存到Redis里面
     * 2、第二个有序集合为延时有序集合，他的成员也是数据行的ID，
     * 而分值则记录了指定数据行的缓存需要每隔多少秒更新一次。
     * ----------------------------------------------------------------------------------------------
     * 为了让缓存函数定期的缓存数据行，程序首先需要将hangID和给定的延迟值添加到延迟有序集合里面，
     * 然后再将行ID和当前指定的时间戳添加到调度有序集合里面。
     */
    public void scheduleRowCache(Jedis conn, String rowId, int delay) {
        //1、先设置数据行的延迟值
        conn.zadd("delay:", delay, rowId);
        //2、立即对需要行村的数据进行调度
        conn.zadd("schedule:", System.currentTimeMillis() / 1000, rowId);
    }
}
