package knowledge.baseKnowledge._javaCore.RedisKn.readisForShopWeb;

/**
 * @project: knowledge.baseKnowledge._javaCore.RedisKn.readisForShopWeb
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/22 13:37
 **/

import com.google.gson.Gson;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.Set;

/**
 * 1、通过组合使用调度函数和持续运行缓存函数，实现类一种重读进行调度的自动缓存机制，
 * 并且可以随心所欲的控制数据行缓存的更新频率：
 * 2、如果数据行记录的是特价促销商品的剩余数量，并且参与促销活动的用户特别多的话，那么最好每隔几秒更新一次数据行缓存：
 * 另一方面，如果数据并不经常改变，或者商品缺货是可以接受的，那么可以每隔几分钟更新一次缓存。
 */
public class CacheRowsThread
        extends Thread {
    private Jedis conn;
    private boolean quit;

    public CacheRowsThread() {
        this.conn = new Jedis("localhost");
        this.conn.select(14);
    }

    public void quit() {
        quit = true;
    }

    public void run() {
        Gson gson = new Gson();
        while (!quit) {
            //1、尝试获取下一个需要被缓存的数据行以及该行的调度时间戳，返回一个包含0个或一个元组列表
            Set<Tuple> range = conn.zrangeWithScores("schedule:", 0, 0);
            Tuple next = range.size() > 0 ? range.iterator().next() : null;
            long now = System.currentTimeMillis() / 1000;
            //2、暂时没有行需要被缓存，休眠50毫秒。
            if (next == null || next.getScore() > now) {
                try {
                    sleep(50);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
                continue;
            }
            //3、提前获取下一次调度的延迟时间，
            String rowId = next.getElement();
            double delay = conn.zscore("delay:", rowId);
            if (delay <= 0) {
                //4、不必在缓存这个行，将它从缓存中移除
                conn.zrem("delay:", rowId);
                conn.zrem("schedule:", rowId);
                conn.del("inv:" + rowId);
                continue;
            }
            //5、继续读取数据行
//            Inventory row = Inventory.get(rowId);
            //6、更新调度时间，并设置缓存值。
            conn.zadd("schedule:", now + delay, rowId);
//            conn.set("inv:" + rowId, gson.toJson(row));
        }
    }
}
