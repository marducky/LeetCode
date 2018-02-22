package knowledge.baseKnowledge._javaCore.safe2Serializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @project: knowledge.baseKnowledge._javaCore.safe2Serializable
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/22 15:53
 **/
public class SerializeSafeDemo2Read {
    public static void main(String[] args) {
        EmployeeSafe e = null;
        try {
            // 打开一个文件输入流
            FileInputStream fileIn = new FileInputStream("./src/knowledge/baseKnowledge/_javaCore/safe2Serializable/EmployeeSafe.db");
            // 建立对象输入流
            ObjectInputStream in = new ObjectInputStream(fileIn);
            // 读取对象
            e = (EmployeeSafe) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }
        System.out.println("Deserialized Employee...");
        System.out.println("Name: " + e.name);
        System.out.println("This is the " + e.identify + " of our company");

    }
}
