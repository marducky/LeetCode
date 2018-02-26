package majors.openSource.BevaSunSong.test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class testlog {
    private static Logger logger = LogManager.getLogger(testlog.class);

    public static void main(String[] args) {
        logger.debug("测试");
        logger.error("错误消息");
    }
}
