package knowledge.multiProcess.chapter3;

import java.io.IOException;
import java.io.PipedOutputStream;

public class PipeInputOutputWriteData {
    public void writeMethod(PipedOutputStream outputStream){
        try {
            System.out.println("Write : ");
            for (int i=0;i<300;i++){
                String outData=""+(i+1);
                outputStream.write(outData.getBytes());
                System.out.print(outData);
            }
        }catch (IOException e){e.printStackTrace();}
    }

}
