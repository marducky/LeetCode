package tools.YamlFormat;

import java.io.*;

public class Write2File {
    private String path;
    private String targetString;

    //Json 可以被转换为String
    //Xml 也可以被转换为String
    //Yaml 也可以被转换为String
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTargetString() {
        return targetString;
    }

    public void setTargetString(String targetString) {
        this.targetString = targetString;
    }

    public Write2File(String path, String targetString) {
        this.path = path;
        this.targetString = targetString;
    }

    public Write2File(String targetString) {
        this.targetString = targetString;
        this.path = "./";
    }

    public void white2File() throws Exception {
        File file = new File(this.path);
        if (file.exists()) {
            FileWriter fileWriter = new FileWriter(file, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("");
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        }
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(this.targetString);
        bufferedWriter.flush();
        bufferedWriter.close();
        fileWriter.close();
    }
}
