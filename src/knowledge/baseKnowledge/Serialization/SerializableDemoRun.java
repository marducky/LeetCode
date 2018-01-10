package knowledge.baseKnowledge.Serialization;


import java.io.*;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class SerializableDemoRun {
    public static void main(String[] args) {
        //Initializes The Object
        SerializableDemo serializableDemo1 = new SerializableDemo();
        serializableDemo1.setName("Janus");
        serializableDemo1.setAge(23);
        System.out.println(serializableDemo1);
        //Write Obj to File
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("tempFile"));
            objectOutputStream.writeObject(serializableDemo1);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(objectOutputStream);
        }
        //Read Obj from File
        File file = new File("tempFile");
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
            SerializableDemo newSerializableDemo = (SerializableDemo) objectInputStream.readObject();
            System.out.println(newSerializableDemo);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(objectInputStream);
            try {
                FileUtils.forceDelete(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
