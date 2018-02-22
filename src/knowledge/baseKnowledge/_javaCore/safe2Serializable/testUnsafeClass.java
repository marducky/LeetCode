package knowledge.baseKnowledge._javaCore.safe2Serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @project: knowledge.baseKnowledge._javaCore.safe2Serializable
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/22 15:55
 **/
public class testUnsafeClass {
    public static void main(String[] args) throws Exception {
        UnsafeClass Unsafe = new UnsafeClass();
        Unsafe.name = "hacked by ph0rse";

        FileOutputStream fos = new FileOutputStream("./src/knowledge/baseKnowledge/_javaCore/safe2Serializable/object");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        //writeObject()方法将Unsafe对象写入object文件
        os.writeObject(Unsafe);
        os.close();
        //从文件中反序列化obj对象
        FileInputStream fis = new FileInputStream("./src/knowledge/baseKnowledge/_javaCore/safe2Serializable/object");
        ObjectInputStream ois = new ObjectInputStream(fis);
        //恢复对象
        UnsafeClass objectFromDisk = (UnsafeClass) ois.readObject();
        System.out.println(objectFromDisk.name);
        ois.close();
    }

}


