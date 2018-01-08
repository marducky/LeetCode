package tools.getHandler;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GetConfFolderList {
    private static String strPath;

    public GetConfFolderList(String strPath) {
        this.strPath = strPath;
    }

    public GetConfFolderList() {
        strPath = "C:";
    }

    public List<String> getFileList(String strPath) {
        File confDir = new File(strPath);
        File[] files = confDir.listFiles();
        List<String> fileStringList = new ArrayList<String>();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {

                if (!files[i].isDirectory()) {
                    fileStringList.add(files[i].getName());
                }
            }
        } else {
            System.out.println("Plz give the true folder!");
        }
        return fileStringList;
    }
}
