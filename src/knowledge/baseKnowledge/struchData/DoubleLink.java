/**
 * Java 实现的双向链表。
 * 注：java自带的集合包中有实现双向链表，路径是:javaInherit.util.LinkedList
 */
package knowledge.baseKnowledge.struchData;

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
    //构造函数
    public DoubleLink(){
        mHead=new DNode<T>(null,null,null);
        mHead.prev=mHead.next=mHead;
        mCount=0;
    }
    public int size(){
        return mCount;
    }
    public boolean isEmpty(){
        return mCount==0;
    }
    private DNode<T> getNode(int index){
        if (index<0||index>=mCount)
            throw new IndexOutOfBoundsException();
        //正向查找
        if (index<mCount/2){
            DNode<T> node=mHead.next;
            for (int i=0;i<index;i++)
                node=node.next;
            return node;
        }
        DNode<T> rnode=mHead.prev;
        int rindex=mCount-index-1;
        for (int j=0;j<rindex;j++)
            rnode=rnode.prev;
        return rnode;
    }
    public T get(int index){
        return getNode(index).value;
    }
    public T getLast(){
        return getNode(mCount-1).value;
    }
    public T getFirst(){
        return getNode(0).value;
    }
    public void insert(int index,T t){
        if (index==0)
        {
            DNode<T> node=new DNode<T>(t,mHead,mHead.next);
            mHead.next.prev=node;
            mHead.next=node;
            mCount++;
            return ;
        }
        DNode<T> inode=getNode(index);
        DNode<T> tnode=new DNode<T>(t,inode.prev,inode);
        inode.prev.next=tnode;
        inode.next=tnode;
        mCount++;
        return ;

    }
    public void insertFirst(T t){
     insert(0,t);
    }
    public void appendLast(T t){
        DNode<T> node=new DNode<T>(t,mHead.prev,mHead);
        mHead.prev.next=node;
        mHead.prev=node;
        mCount++;
    }
    public void del(int index){
        DNode<T> inode=getNode(index);
        inode.prev.next=inode.next;
        inode.next.prev=inode.prev;
        mCount--;
    }
    public void deleteFirst(){
        del(0);
    }
    public void deleteLast(){
        del(mCount-1);
    }

}
