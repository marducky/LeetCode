//learn from http://blog.csdn.net/jiangxinyu/article/details/7885518/
package knowledge.baseKnowledge.javaIoKn;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
public class FileWriterReader {
    /**
     * @param args
     */
    public static void main(String[] args){
        File file=new File("g://","licenseTTT.txt");
        File fileTTT=new File("g://","license.txt");
        try {
            file.createNewFile();
        }catch (IOException e){
            e.printStackTrace();
        }
        String string="I am working in Nuance. ";
        byte bt[] =new byte[1024];
        bt=string.getBytes();
        try {
            FileOutputStream in =new FileOutputStream(file);
            try {
                in.write(bt,0,bt.length);
                in.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        try {
            FileInputStream out=new FileInputStream(file);
            InputStreamReader isr=new InputStreamReader(out);
            int ch=0;
            while ((ch=isr.read())!=-1){
                System.out.print((char) ch);
            }
        }catch (Exception e){

        }
    }

}
