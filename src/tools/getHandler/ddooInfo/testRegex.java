package tools.getHandler.ddooInfo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testRegex {
    public static void main(String[] args) {
//        Pattern pattern=Pattern.compile("<nlus name=\"[\\s\\S]*\">");
////        Matcher matcher=pattern.matcher("<nlus name=\"url-gen-sequence\">");
//        Matcher matcher=pattern.matcher("\t<nlus name=\"url-gen-sequence\">");
//
//        while (matcher.find()){
//            System.out.println(matcher.group(0));
////            System.out.println(matcher.groupCount());
//        }
        String newFilePathName = "C:\\Users\\neng.qi\\Desktop\\handlers-manager-demo.xml";
        File newFile = new File(newFilePathName);
        try {
            if (!newFile.exists()) {
                newFile.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(newFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("sssss\n");
            bufferedWriter.write("=======\n");
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
