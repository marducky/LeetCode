package knowledge.javaCoreTwo.chapter1;

import java.io.*;

public class SerizableDemo {
    //first , we must open a ObjectOutputStream
    public void Seriazable() {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Temp"));
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Temp"));
            objectOutputStream.writeObject(new int[2]);
            try {
                int[] i = (int[]) objectInputStream.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
