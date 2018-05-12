package majors.RedisInAction.RedisPlusMysql.controller;

import majors.RedisInAction.RedisPlusMysql.model.LogClassForRedis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/05/10 11:10
 **/
@Component
public class MybatisController {
    @Autowired
    SqlSessionFactory sqlsessionfactory;

    public void insertLogClass(LogClassForRedis classForRedis) {
        SqlSession sqlSession = sqlsessionfactory.openSession();
        sqlSession.insert("logMybatis.insertToLogRedis", classForRedis);
        sqlSession.close();
        sqlSession.commit();
    }

}
