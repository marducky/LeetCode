package tools.getHandler.bbbboooooInfo;

import java.io.File;
import java.io.IOException;

public class GetPathTwo {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));//G:\info\NLPS_Code_Repos\git\LeetCode
        File file = new File("./abc");

        try {
            System.out.println(file.getAbsolutePath());
            System.out.println(file.getCanonicalPath());
            System.out.println(file.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
