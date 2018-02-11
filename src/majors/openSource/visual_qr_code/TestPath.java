package majors.openSource.visual_qr_code;

import java.io.File;

/**
 * @project: majors.openSource.visual_qr_code
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/11 11:34
 **/
public class TestPath {

    private void getPath() {
        File f = new File(this.getClass().getResource("").getPath());
        System.out.println(f);
        System.out.println(TestPath.class.getClassLoader().getResource(""));
    }

    public static void main(String[] args) throws Exception {
        //main function.
//        File file=new File("out");
//        //System.out.println() from template!
//        System.out.println(file.getAbsolutePath().toString());
//        //System.out.println() from template!
//        System.out.println(System.getProperty("user.dir"));
//        //System.out.println() from template!
//        System.out.println(TestPath.class.getClass().getResource("").getPath());
//        //System.out.println() from template!
//        System.out.println(TestPath.class.getResource("/"));
//        //System.out.println() from template!
//        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
//        System.out.println(TestPath.class.getClassLoader().getResource("/"));
//        System.out.println(TestPath.class.getClass().getResource("erro.md"));
//        System.out.println( System.getProperty("TestPath.class.path"));
        TestPath testPath = new TestPath();
        testPath.getPath();
    }

}
