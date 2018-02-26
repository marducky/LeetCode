package majors.openSource.BevaSunSong.java;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @project: majors.openSource.BevaSunSong
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/26 10:41
 **/
public class Write2FileHandler {
    private String filePath;
    private String fileName;
    private Object content;

    public Write2FileHandler(String filePath, String fileName, Object content) {
        this.filePath = filePath;
        this.fileName = fileName;
        this.content = content;
        write2File();

    }

    public Write2FileHandler(String fileName, Object content) {
        this.filePath = "./src/majors/openSource/BevaSunSong/resource";
        this.fileName = fileName;
        this.content = content;
        write2File();
    }

    public Write2FileHandler(Object content) {
        this.filePath = "./src/majors/openSource/BevaSunSong/resource";
        this.fileName = "temp";
        this.content = content;
        write2File();
    }

    private void write2File() {
        if (!this.filePath.endsWith("/")) {
            this.filePath = filePath + "/";
        }
        File file = new File(filePath + "" + fileName);

        try {
            FileWriter fileWriterClear = new FileWriter(file, false);

            if (!file.exists()) {
                file.createNewFile();
                fileWriterClear.write(this.content.toString());
            } else {
                fileWriterClear.write("");
                fileWriterClear.write(this.content.toString());
            }
            fileWriterClear.flush();
            fileWriterClear.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
