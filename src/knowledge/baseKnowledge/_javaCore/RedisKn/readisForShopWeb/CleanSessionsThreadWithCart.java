package knowledge.baseKnowledge._javaCore.RedisKn.readisForShopWeb;

import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.Set;

/**
 * @project: knowledge.baseKnowledge._javaCore.RedisKn.readisForShopWeb
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/22 13:28
 **/
public class CleanSessionsThreadWithCart extends Thread {
    private Jedis conn;
    private int limit = 10000;
    private boolean quit;

    public CleanSessionsThreadWithCart(int limit) {
        this.conn = new Jedis("localhost");
        this.conn.select(14);
        this.limit = limit;
    }

    public void quit() {
        quit = true;
    }

    public void run() {
        while (!quit) {
            //1、找出目前已有令牌的数量。
            long size = conn.zcard("recent:");
            //2、令牌数量未超过限制，休眠1秒，并在之后重新检查
            if (size <= limit) {
                try {
                    sleep(1000);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
                continue;
            }

            long endIndex = Math.min(size - limit, 100);
            //3、获取需要移除的令牌ID
            Set<String> tokenSet = conn.zrange("recent:", 0, endIndex - 1);
            String[] tokens = tokenSet.toArray(new String[tokenSet.size()]);

            ArrayList<String> sessionKeys = new ArrayList<String>();
            for (String token : tokens) {
                //4、为那些将要被删除的令牌构建键名
                sessionKeys.add("viewed:" + token);
                //新增加的这两行代码用于删除旧会话对应的购物车。
                //新增加的这两行代码用于删除旧会话对应的购物车。
//                sessionKeys.add("cart:" + sess);
                sessionKeys.add("cart:" + token);
            }
            //5、移除最旧的令牌
            conn.del(sessionKeys.toArray(new String[sessionKeys.size()]));
            //6、移除被删除令牌对应的用户信息
            conn.hdel("login:", tokens);
            //7、移除用户最近浏览商品记录。
            conn.zrem("recent:", tokens);
        }
    }
}
