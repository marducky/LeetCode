package knowledge.baseKnowledge.jvm.chapter3;

public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;
    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        ReferenceCountingGC referenceCountingGCOne = new ReferenceCountingGC();
        ReferenceCountingGC referenceCountingGCTwo = new ReferenceCountingGC();
        referenceCountingGCOne.instance = referenceCountingGCTwo;
        referenceCountingGCTwo.instance = referenceCountingGCOne;
        referenceCountingGCOne = null;
        referenceCountingGCTwo = null;
        System.gc();
    }
}
