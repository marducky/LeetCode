package knowledge.baseKnowledge.regrexKn;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class StatisticsProjectCode {
    //this is the no code line.
    private static long whiteLines = 0;
    //this is the code line.
    private static long normalLines = 0;
    //this is the description line.
    private static long commentLines = 0;
    //this is the code counter.
    private static long javaCodeFlieCounter;

    /*
    * 获取总行数
    * */
    private static long getTotalLines() {
        long value = whiteLines + normalLines + commentLines;
        return value;
    }

    /**
     * 遍历所有java 源文件
     */
    private static void parse(File srcDir) {
        BufferedReader bufferedReader = null;
        boolean comment = false;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(srcDir)));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim();
                if (line.matches("^[\\s&&[^\\n]]*$")) {
                    whiteLines++;
                } else if (line.startsWith("/*")) {
                    commentLines++;
                    comment = true;
                } else if (comment == true) {
                    commentLines++;
                    if (line.endsWith("*/")) {
                        comment = false;
                    }
                } else if (line.contains("//")) {
                    commentLines++;

                } else {
                    normalLines++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    *获取javaList
    *
     */
    private static void myList(File srcDir) {
//        System.out.println(srcDir+"this 目录下的目录和子文件有： ");
        File[] files = srcDir.listFiles();
        for (File file : files) {
//            System.out.println("------------\n"+file);
            if (file.getName().matches(".*\\.java$")) {
//                System.out.println(file.getName().toString());
                System.out.println(file);
                javaCodeFlieCounter++;
                parse(file);
            }
            if (file.isDirectory()) {
                myList(file);
            }
        }
    }

    public static void main(String[] args) {
//        String projectPath=StatisticsProjectCode.class.getClassLoader().getResource("").toString();
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
//        File srcDir = new File("G:\\info\\NLPS_Code_Repos\\git\\LeetCode");
        File srcDir = new File(projectPath);
//        File srcDir=new File("G:\\info\\NLPS_Code_Repos\\git\\_nlps");
        myList(srcDir);// 遍历所java源文件
        System.out.println("whiteLines = " + whiteLines);
        System.out.println("normalLines = " + normalLines);
        System.out.println("commentLines = " + commentLines);
        System.out.println("totalLines = " + getTotalLines());
        System.out.println("javaCodeFileCounter = " + javaCodeFlieCounter);
//        Map<String,String> map=new HashMap<String, String>();
//        System.out.println(map.get(1));
//        int[] ints=new int[3];
//        System.out.println(ints[3]);
    }
}
