//https://www.cnblogs.com/redcreen/articles/1955307.html
/**
 * Java序列化算法透析
 * <p>
 * Serialization（序列化）是一种将对象以一连串的字节描述的过程；反序列化deserialization是一种将这些字节重建成一个对象的过程。Java序列化API提供一种处理对象序列化的标准机制。在这里你能学到如何序列化一个对象，什么时候需要序列化以及Java序列化的算法，我们用一个实例来示范序列化以后的字节是如何描述一个对象的信息的。
 * <p>
 * 序列化的必要性
 * <p>
 * Java中，一切都是对象，在分布式环境中经常需要将Object从这一端网络或设备传递到另一端。
 * 这就需要有一种可以在两端传输数据的协议。Java序列化机制就是为了解决这个问题而产生。
 * <p>
 * 如何序列化一个对象
 * <p>
 * 一个对象能够序列化的前提是实现Serializable接口，Serializable接口没有方法，更像是个标记。
 * 有了这个标记的Class就能被序列化机制处理。
 */
package knowledge.baseKnowledge.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class parent implements Serializable {
    int parentVersion = 10;
}

class contain implements Serializable {
    int containVersion = 11;
}

public class SerializationProcess extends parent implements Serializable {
    int version = 66;
    contain con = new contain();

    public int getVersion() {
        return version;
    }

    public static void main(String args[]) throws IOException {
        FileOutputStream fos = new FileOutputStream("tempFile");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        SerializationProcess st = new SerializationProcess();
        oos.writeObject(st);
        oos.flush();
        oos.close();
    }
}