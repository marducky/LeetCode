/**
 * 最后的输出是 10，对于无法理解的读者认为，打印的 staticVar 是从读取的对象里获得的，应该是保存时的状态才对。之所以打印 10 的原因在于序列化时，并不保存静态变量，这其实比较容易理解，序列化保存的是对象的状态，静态变量属于类的状态，因此 序列化并不保存静态变量。
 */
package knowledge.baseKnowledge.serialization;

import java.io.*;

public class StaticParamSerializable implements Serializable {
    private static final long serialVersionUID = 1L;
    public static int staticVar = 5;


    public static void main(String[] args) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("result.obj"));
            objectOutputStream.writeObject(new StaticParamSerializable());
            objectOutputStream.close();

            StaticParamSerializable.staticVar = 10;
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("result.obj"));
            StaticParamSerializable staticParamSerializable = (StaticParamSerializable) inputStream.readObject();
            inputStream.close();
            System.out.println(staticParamSerializable.staticVar);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
