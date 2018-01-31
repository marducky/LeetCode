package knowledge.baseKnowledge.regrexKn;

import java.io.*;

public class SendNinaUseCasesPost {
    public void getPostJsonModule(String pathName){
        File file=new File(pathName+"\\PostJson.txt");
        try {
            FileInputStream fileInputStream=new FileInputStream(file);
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String line="";
            while ((line=bufferedReader.readLine())!=null){
//                if (line.)
            }
        }catch (IOException e){e.printStackTrace();}
    }
}
