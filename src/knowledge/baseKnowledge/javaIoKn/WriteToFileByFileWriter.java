package knowledge.baseKnowledge.javaIoKn;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class WriteToFileByFileWriter {
    public void writeToFile(String targetString, String filePath) {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                if (file.isFile()) {
                    FileWriter fileWriter = new FileWriter(file, false);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    bufferedWriter.write(targetString);
                    bufferedWriter.close();
                    fileWriter.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String s = "sssss";
        String filePath = "C:\\Users\\neng.qi\\Desktop\\fileIOtest.txt";
        WriteToFileByFileWriter writeToFileByFileWriter = new WriteToFileByFileWriter();
        writeToFileByFileWriter.writeToFile(s, filePath);
    }
}
