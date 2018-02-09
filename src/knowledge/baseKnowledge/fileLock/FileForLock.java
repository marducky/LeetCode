package knowledge.baseKnowledge.fileLock;
// “Locks are associated with files, not channels. Use locks to coordinate with external processes, not between threads in the same JVM.”
/**
 * channels1. 概念
 * <p>
 * 共享锁: 共享读操作，但只能一个写（读可以同时，但写不能）。共享锁防止其他正在运行的程序获得重复的独占锁，但是允许他们获得重复的共享锁。
 * 独占锁: 只有一个读或一个写（读和写都不能同时）。独占锁防止其他程序获得任何类型的锁。
 * 2. FileLock FileChannel.lock(long position, long size, boolean shared)
 * <p>
 * shared的含义:是否使用共享锁,一些不支持共享锁的操作系统,将自动将共享锁改成排它锁。可以通过调用isShared()方法来检测获得的是什么类型的锁。
 * 3. lock()和tryLock()的区别：
 * <p>
 * lock()阻塞的方法，锁定范围可以随着文件的增大而增加。无参lock()默认为独占锁；有参lock(0L, Long.MAX_VALUE, true)为共享锁。
 * tryLock()非阻塞,当未获得锁时,返回null.
 * 4. FileLock的生命周期：在调用FileLock.release(),或者Channel.close(),或者JVM关闭
 * <p>
 * 5. FileLock是线程安全的
 * 同一进程内，在文件锁没有被释放之前，不可以再次获取。即在release()方法调用前,只能lock()或者tryLock()一次。
 * 文件锁的效果是与操作系统相关的。一些系统中文件锁是强制性的，就当Java的某进程获得文件锁后，操作系统将保证其它进程无法对文件做操作了。而另一些操作系统的文件锁是询问式的(advisory)，意思是说要想拥有进程互斥的效果，其它的进程也必须也按照API所规定的那样来申请或者检测文件锁，不然将起不到进程互斥的功能。所以文档里建议将所有系统都当做是询问式系统来处理，这样程序更加安全也更容易移植。
 * 如何避免死锁：在读写关键数据时加锁，操作完成后解锁；一次性申请所有需要的资源，并且在申请不成功的情况下放弃已申请到的资源。
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.sql.Date;

/**
 * @project: knowledge.baseKnowledge._javaCore.javaCoreBookTwo.chapter1
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/09 11:40
 **/
public class FileForLock {
    private static void giveFileLocke() {
//        FileLock fileLock=channels.FileLock();        }
        FileChannel fileChannel = null;
        FileLock fileLock = null;
        try {
            //1. 对于一个只读文件通过任意方式加锁时会报NonWritableChannelException异常
            //2. 无参lock()默认为独占锁，不会报NonReadableChannelException异常，因为独占就是为了写
            //3. 有参lock()为共享锁，所谓的共享也只能读共享，写是独占的，共享锁控制的代码只能是读操作，当有写冲突时会报NonWritableChannelException异常
            fileChannel = new FileOutputStream("G:\\info\\NLPS_Code_Repos\\git\\LeetCode\\src\\knowledge\\_javaCore\\javaCoreBookTwo\\chapter1\\testFile/logfile.txt", true).getChannel();
            RandomAccessFile randomAccessFile = new RandomAccessFile("G:\\info\\NLPS_Code_Repos\\git\\LeetCode\\src\\knowledge\\_javaCore\\javaCoreBookTwo\\chapter1\\testFile/logfile.txt", "rw");
            randomAccessFile.seek(randomAccessFile.length());
            fileChannel = randomAccessFile.getChannel();
            fileLock = fileChannel.lock(); //获得锁方法一：lock()，阻塞的方法，当文件锁不可用时，当前进程会被挂起
            //lock = channel.lock(0L, Long.MAX_VALUE, true);//有参lock()为共享锁，有写操作会报异常

            //获得锁方法二：trylock()，非阻塞的方法，当文件锁不可用时，tryLock()会得到null值
            //do {
            //  lock = channel.tryLock();
            //} while (null == lock);
//互斥操作
            String s = "sss";
            ByteBuffer sendBuffer = ByteBuffer.wrap(s.getBytes());
            fileChannel.write(sendBuffer);
            Thread.sleep(5000);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {


                if (fileLock != null) {
                    fileLock.release();
                    fileLock = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (fileChannel != null) {
            try {
                fileChannel.close();
                fileChannel = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //main function.
        //System.out.println() from template!
        System.out.println();
        giveFileLocke();
    }
}

