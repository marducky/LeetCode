package tools.getHandler;

import java.io.File;
import java.io.FileOutputStream;

public class ReadConfFileLine {
    private String strPath;
    private String fileName;

    public ReadConfFileLine(String strPath, String fileName) {
        this.fileName = fileName;
        this.strPath = strPath;
    }

    public ReadConfFileLine(String fileName) {
        this.fileName = fileName;
    }

    public boolean isValidConf() {
        if ((this.strPath == null) || (this.strPath == "")) {
            GetConfFolderList folderList = new GetConfFolderList("C:");
            for (String temp : folderList.getFileList("C:")) {
                if (temp.equals(fileName))
                    return true;
            }

        } else {
            GetConfFolderList folderList = new GetConfFolderList(strPath);
            for (String temp : folderList.getFileList(strPath)) {
                if (temp.equals(fileName))
                    return true;
            }
        }
        return false;
    }

    public FileOutputStream fileOutputStream() {
        File file = new File(this.strPath + "/" + fileName);

        return null;
        //TODO:The next work.
    }


}


