package knowledge.multiProcess.chapter3;

import java.io.IOException;
import java.io.PipedInputStream;

public class PipeInputOutputReadData {
    public void readMethod(PipedInputStream inputStream){
        try {
            System.out.println("Read: ");
            byte[] byteArray=new byte[20];
            int readLength=inputStream.read(byteArray);
            while (readLength!=-1){
                String newData=new String(byteArray,0,readLength);
                System.out.print(newData);
                readLength=inputStream.read(byteArray);
            }
            System.out.println();
            inputStream.close();
        }catch (IOException e){e.printStackTrace();}
    }
}
