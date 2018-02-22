package knowledge.baseKnowledge._javaCore.safe2Serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @project: knowledge.baseKnowledge._javaCore.safe2Serializable
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/22 15:44
 **/
public class SerializeSafeDemo2Write {
    public static void main(String[] args) {
        EmployeeSafe e = new EmployeeSafe();
        e.name = "员工甲";
        e.identify = "General staff";
        try {
            // 打开一个文件输入流
            FileOutputStream fileOut =
                    new FileOutputStream("./src/knowledge/baseKnowledge/_javaCore/safe2Serializable/EmployeeSafe.db");
            // 建立对象输入流
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            //输出反序列化对象
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in ./src/knowledge/baseKnowledge/_javaCore/safe2Serializable/EmployeeSafe.db");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
