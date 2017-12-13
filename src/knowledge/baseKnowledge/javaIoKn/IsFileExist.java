package knowledge.baseKnowledge.javaIoKn;

import java.io.File;
import java.io.IOException;

public class IsFileExist {
    public void isFileExist(String path,String filename){
        File file=new File(path,filename);
        if (!file.exists()){
            file.mkdir();
        }
        if (!file.exists()){
            try {
                file.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
