package majors.RedisInAction.Chapter1;

import redis.clients.jedis.Jedis;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/04/20 15:58
 **/
public class ActileVote {
    private static final Jedis jedis = new Jedis("localhost");

    public static void articleVoteMethod(String user, String articleId) {
        //add the article add user;
        String actualStoreId = "article:" + articleId;
        String actualUserId = "user:" + articleId;
        if (!jedis.sismember(actualStoreId, actualUserId)) {
            jedis.sadd("article:" + articleId, "user:" + user);
            if ((jedis.zscore("Time", "article:" + articleId) - System.currentTimeMillis() / 1000) < 86400 * 7) {
                jedis.zadd("Score", Double.valueOf(jedis.zcard(actualStoreId) + 432), "article:" + articleId);
            }

        }

    }

    public static void main(String[] args) {

        articleVoteMethod("1", "2");
    }
}
