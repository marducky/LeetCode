package knowledge.baseKnowledge._javaCore.CASCompareSwap;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @project: knowledge.baseKnowledge._javaCore.CASCompareSwap
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/22 15:21
 **/
public class CASDemo2Atomic {
    // setup to use Unsafe.compareAndSwapInt for updates
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static final long valueOffset;

    static {
        try {
            valueOffset = unsafe.objectFieldOffset
                    (AtomicInteger.class.getDeclaredField("value"));
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }

    private volatile int value;

    public final int get() {
        return value;
    }
}
