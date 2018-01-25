package knowledge.baseKnowledge.javaGetTheClassPath;

import java.io.File;

public class GetPath {
    public static void main(String[] args) {
        System.out.println(GetPath.class.getResource("/"));
        //result:/G:/info/NLPS_Code_Repos/git/LeetCode/out/production/LeetCode/
        System.out.println(GetPath.class.getResource(""));
        //result:/G:/info/NLPS_Code_Repos/git/LeetCode/out/production/LeetCode/knowledge/baseKnowledge/javaGetTheClassPath/
        System.out.println(GetPath.class.getClassLoader().getResource(""));
        //file:/G:/info/NLPS_Code_Repos/git/LeetCode/out/production/LeetCode/
        System.out.println(System.getProperty("user.dir"));
        //G:\info\NLPS_Code_Repos\git\LeetCode
        File directory = new File("");//设定为当前文件夹
        try {
            System.out.println(directory.getCanonicalPath());//获取标准的路径
            //G:\info\NLPS_Code_Repos\git\LeetCode
            System.out.println(directory.getAbsolutePath());//获取绝对路径
            //G:\info\NLPS_Code_Repos\git\LeetCode
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(GetPath.class.getClassLoader().getResource("source.xml"));
        System.out.println(GetPath.class.getClassLoader().getResource(""));
        System.out.println(GetPath.class.getResource("source.xml"));
        String sss = GetPath.class.getResource("").toString();
        System.out.println(sss.substring(sss.indexOf("/") + 1, sss.length()));


    }
}
