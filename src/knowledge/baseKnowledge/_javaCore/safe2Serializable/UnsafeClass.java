package knowledge.baseKnowledge._javaCore.safe2Serializable;

import java.io.IOException;
import java.io.Serializable;

/**
 * @project: knowledge.baseKnowledge._javaCore.safe2Serializable
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/22 15:56
 **/
public class UnsafeClass implements Serializable {
    public String name;

    //重写readObject()方法
    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        //执行默认的readObject()方法
        in.defaultReadObject();
        //执行命令
        Runtime.getRuntime().exec("calc.exe");
    }
}
