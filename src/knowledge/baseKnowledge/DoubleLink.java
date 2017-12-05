/**
 * Java 实现的双向链表。
 * 注：java自带的集合包中有实现双向链表，路径是:java.util.LinkedList
 */
package knowledge.baseKnowledge;

public class DoubleLink<T> {
    private DNode<T> mHead;//头结点；
    private int mCount;
    private class DNode<T>{
        public DNode prev;
        public DNode next;
        public T value;
        public DNode(T value,DNode prev,DNode next){
            this.value=value;
            this.prev=prev;
            this.next=next;
        }
    }
    public DoubleLink(){

    }


}
