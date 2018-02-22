package knowledge.baseKnowledge._javaCore.CASCompareSwap;

/**
 * @project: knowledge.baseKnowledge._javaCore.CASCompareSwap
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/22 15:17
 **/
public class CASDemo2Synchronized {
    public volatile int n;

    public synchronized void add() {
        n++;
    }

    public static void main(String[] args) {
        CASDemo2Synchronized casDemo = new CASDemo2Synchronized();
        casDemo.add();

    }
}
