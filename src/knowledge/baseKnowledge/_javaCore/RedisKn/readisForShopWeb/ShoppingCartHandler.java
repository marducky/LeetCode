package knowledge.baseKnowledge._javaCore.RedisKn.readisForShopWeb;

import redis.clients.jedis.Jedis;

/**
 * @project: knowledge.baseKnowledge._javaCore.RedisKn.readisForShopWeb
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/22 13:30
 **/
public class ShoppingCartHandler {
    /**
     * 使用cookie实现购物车——就是将整个购物车都存储到cookie里面，
     * 优点：无需对数据库进行写入就可以实现购物车功能，
     * 缺点：怎是程序需要重新解析和验证cookie，确保cookie的格式正确。并且包含商品可以正常购买
     * 还有一缺点：因为浏览器每次发送请求都会连cookie一起发送，所以如果购物车的体积较大，
     * 那么请求发送和处理的速度可能降低。
     * -----------------------------------------------------------------
     * 1、每个用户的购物车都是一个散列，存储了商品ID与商品订单数量之间的映射。
     * 2、如果用户订购某件商品的数量大于0，那么程序会将这件商品的ID以及用户订购该商品的数量添加到散列里。
     * 3、如果用户购买的商品已经存在于散列里面，那么新的订单数量会覆盖已有的。
     * 4、相反，如果某用户订购某件商品数量不大于0，那么程序将从散列里移除该条目
     * 5、需要对之前的会话清理函数进行更新，让它在清理会话的同时，将旧会话对应的用户购物车也一并删除。
     */
    public void addToCart(Jedis conn, String session, String item, int count) {
        if (count <= 0) {
            //1、从购物车里面移除指定的商品
            conn.hdel("cart:" + session, item);
        } else {
            //2、将指定的商品添加到购物车
            conn.hset("cart:" + session, item, String.valueOf(count));
        }
    }
}
