package majors.MyBatisKn.controller;

import lombok.extern.slf4j.Slf4j;
import majors.MyBatisKn.model.LogClass;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/05/10 10:31
 **/
@Slf4j
public class LogMybatisTest {
    private SqlSessionFactory sqlsessionfactory;

    @Before
    public void star() throws Exception {
        //设置配置路径，mybitis是以SqlMapConfig.xml为主路径。因为SqlMapConfig中的mapper关联了user.xml
        //因为在config根目录下，所以可以直接引用而不用带config
        String resource = "majors/MyBatisKn/resource/SqlMapConfig.xml";
        //SqlMapConfig.xml读给输入流，使用mybitis的Resources类下的getResourceAsStream实现
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建Mybitis的SqlSessionFactory工厂类
        sqlsessionfactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test() {
        //通过工厂类打开数据接口
        SqlSession sqlsession = sqlsessionfactory.openSession();
        //设置接收对象
        LogClass user = null;

        try {
            //查询数据selectOne为查询一条的方法第一个参数是user.xml中的namespace.id；第二个参数是user配置文件中的#{id}
            user = sqlsession.selectOne("test.findUserById", 1);
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            sqlsession.close();//读完要关闭sqlsession
        }
        System.out.println(user);//打印输出
    }

    @Test
    public void testInsert() {
        SqlSession sqlSession = sqlsessionfactory.openSession();
        LogClass logClass = new LogClass();
//        logClass.setLog_id(3);
        logClass.setLog_info("test log info");
        logClass.setLog_time(" hhh");
        try {
            sqlSession.insert("test.insertToLogRedis", logClass);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void gcc() {
//        System.gc();
        String nlpsConfigHome = System.getenv("NLPS_CONFIG_HOME");
        System.out.println(nlpsConfigHome);
    }
}
