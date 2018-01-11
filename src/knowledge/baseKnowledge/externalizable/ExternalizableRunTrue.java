package knowledge.baseKnowledge.externalizable;

import java.io.*;

/**
 * Created by hollis on 16/2/17.
 */
public class ExternalizableRunTrue {

    //为了便于理解和节省篇幅，忽略关闭流操作及删除文件操作。真正编码时千万不要忘记
    //IOException直接抛出
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Write Obj to file
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
        ExternalizableDemoTrue user = new ExternalizableDemoTrue();
        user.setName("hollis");
        user.setAge(23);
        oos.writeObject(user);
        //Read Obj from file
        File file = new File("tempFile");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        ExternalizableDemoTrue newInstance = (ExternalizableDemoTrue) ois.readObject();
        //output
        System.out.println(newInstance);
    }
}
/**
 * 通过上面的实例可以发现，对User1类进行序列化及反序列化之后得到的对象的所有属性的值都变成了默认值。也就是说，之前的那个对象的状态并没有被持久化下来。这就是Externalizable接口和Serializable接口的区别：
 * <p>
 * Externalizable继承了Serializable，该接口中定义了两个抽象方法：writeExternal()与readExternal()。当使用Externalizable接口来进行序列化与反序列化的时候需要开发人员重写writeExternal()与readExternal()方法。由于上面的代码中，并没有在这两个方法中定义序列化实现细节，所以输出的内容为空。还有一点值得注意：在使用Externalizable进行序列化的时候，在读取对象时，会调用被序列化类的无参构造器去创建一个新的对象，然后再将被保存对象的字段的值分别填充到新对象中。所以，实现Externalizable接口的类必须要提供一个public的无参的构造器。
 * <p>
 * ObjectOutput和ObjectInput 接口
 * <p>
 * ObjectInput接口 扩展自 DataInput 接口以包含对象的读操作。
 * <p>
 * DataInput 接口用于从二进制流中读取字节，并根据所有 Java 基本类型数据进行重构。同时还提供根据 UTF-8 修改版格式的数据重构 String 的工具。
 * <p>
 * 对于此接口中的所有数据读取例程来说，如果在读取所需字节数之前已经到达文件末尾 (end of file)，则将抛出 EOFException（IOException 的一种）。如果因为到达文件末尾以外的其他原因无法读取字节，则将抛出 IOException 而不是 EOFException。尤其是，在输入流已关闭的情况下，将抛出 IOException。
 * <p>
 * ObjectOutput 扩展 DataOutput 接口以包含对象的写入操作。
 * <p>
 * DataOutput 接口用于将数据从任意 Java 基本类型转换为一系列字节，并将这些字节写入二进制流。同时还提供了一个将 String 转换成 UTF-8 修改版格式并写入所得到的系列字节的工具。
 * <p>
 * 对于此接口中写入字节的所有方法，如果由于某种原因无法写入某个字节，则抛出 IOException。
 * <p>
 * ObjectOutputStream类和ObjectInputStream类
 * <p>
 * 通过前面的代码片段中我们也能知道，我们一般使用ObjectOutputStream的writeObject方法把一个对象进行持久化。再使用ObjectInputStream的readObject从持久化存储中把对象读取出来。
 * <p>
 * 更多关于ObjectInputStream和ObjectOutputStream的相关知识欢迎阅读我的另外两篇博文：深入分析Java的序列化与反序列化、单例与序列化的那些事儿
 * <p>
 * Transient 关键字
 * <p>
 * Transient 关键字的作用是控制变量的序列化，在变量声明前加上该关键字，可以阻止该变量被序列化到文件中，在被反序列化后，transient 变量的值被设为初始值，如 int 型的是 0，对象型的是 null。关于Transient 关键字的拓展知识欢迎阅读深入分析Java的序列化与反序列化
 * <p>
 * 序列化ID
 * <p>
 * 虚拟机是否允许反序列化，不仅取决于类路径和功能代码是否一致，一个非常重要的一点是两个类的序列化 ID 是否一致（就是 private static final long serialVersionUID)
 * <p>
 * 序列化 ID 在 Eclipse 下提供了两种生成策略，一个是固定的 1L，一个是随机生成一个不重复的 long 类型数据（实际上是使用 JDK 工具生成），在这里有一个建议，如果没有特殊需求，就是用默认的 1L 就可以，这样可以确保代码一致时反序列化成功。那么随机生成的序列化
 */
//OutPut:
//User{name='null', age=0}
/**
 * ObjectOutput和ObjectInput 接口

 ObjectInput接口 扩展自 DataInput 接口以包含对象的读操作。

 DataInput 接口用于从二进制流中读取字节，并根据所有 Java 基本类型数据进行重构。同时还提供根据 UTF-8 修改版格式的数据重构 String 的工具。

 对于此接口中的所有数据读取例程来说，如果在读取所需字节数之前已经到达文件末尾 (end of file)，则将抛出 EOFException（IOException 的一种）。如果因为到达文件末尾以外的其他原因无法读取字节，则将抛出 IOException 而不是 EOFException。尤其是，在输入流已关闭的情况下，将抛出 IOException。

 ObjectOutput 扩展 DataOutput 接口以包含对象的写入操作。

 DataOutput 接口用于将数据从任意 Java 基本类型转换为一系列字节，并将这些字节写入二进制流。同时还提供了一个将 String 转换成 UTF-8 修改版格式并写入所得到的系列字节的工具。

 对于此接口中写入字节的所有方法，如果由于某种原因无法写入某个字节，则抛出 IOException。

 ObjectOutputStream类和ObjectInputStream类

 通过前面的代码片段中我们也能知道，我们一般使用ObjectOutputStream的writeObject方法把一个对象进行持久化。再使用ObjectInputStream的readObject从持久化存储中把对象读取出来。

 更多关于ObjectInputStream和ObjectOutputStream的相关知识欢迎阅读我的另外两篇博文：深入分析Java的序列化与反序列化、单例与序列化的那些事儿

 Transient 关键字

 Transient 关键字的作用是控制变量的序列化，在变量声明前加上该关键字，可以阻止该变量被序列化到文件中，在被反序列化后，transient 变量的值被设为初始值，如 int 型的是 0，对象型的是 null。关于Transient 关键字的拓展知识欢迎阅读深入分析Java的序列化与反序列化

 序列化ID

 虚拟机是否允许反序列化，不仅取决于类路径和功能代码是否一致，一个非常重要的一点是两个类的序列化 ID 是否一致（就是 private static final long serialVersionUID)

 序列化 ID 在 Eclipse 下提供了两种生成策略，一个是固定的 1L，一个是随机生成一个不重复的 long 类型数据（实际上是使用 JDK 工具生成），在这里有一个建议，如果没有特殊需求，就是用默认的 1L 就可以，这样可以确保代码一致时反序列化成功。那么随机生成的序列化
 */
