package majors.openSource.BevaSunSong.test;

import majors.openSource.BevaSunSong.java.Write2FileHandler;
import org.junit.Test;

/**
 * @project: majors.openSource.BevaSunSong.test
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/26 11:02
 **/
public class testWrite2File {
    @Test
    public void testWrite2File1Content() {
        Write2FileHandler write2FileHandler = new Write2FileHandler("www");
    }

    @Test
    public void testWrite2File2FilenameContent() {
        new Write2FileHandler("testWrite2File2FilenameContent", "wwwwww");
    }

    @Test
    public void testWrite2File3FilePathFilenameContent() {
        new Write2FileHandler("./src/majors/openSource/BevaSunSong/resource", "testWrite2File3FilePathFilenameContent", "www");
    }
}
