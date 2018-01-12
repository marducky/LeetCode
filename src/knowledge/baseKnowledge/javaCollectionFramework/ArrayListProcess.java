//http://www.cnblogs.com/CarpenterLee/p/5419880.html
//ArrayList实现了List接口，是顺序容器，即元素存放的数据与放进去的顺序相同，允许放入null元素，底层通过数组实现。除该类未实现同步外，其余跟Vector大致相同。每个ArrayList都有一个容量（capacity），表示底层数组的实际大小，容器内存储元素的个数不能多于当前容量。当向容器中添加元素时，如果容量不足，容器会自动增大底层数组的大小。前面已经提过，Java泛型只是编译器提供的语法糖，所以这里的数组是一个Object数组，以便能够容纳任何类型的对象。

package knowledge.baseKnowledge.javaCollectionFramework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ArrayListProcess {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            arrayList.add(random.nextInt());
        }
        arrayList.set(0, 333333);
        /**
         *     public E set(int index, E element) {
         rangeCheck(index);

         E oldValue = elementData(index);
         elementData[index] = element;
         return oldValue;
         }
         */
        arrayList.add(1, 4444);
        /**
         *     public void add(int index, E element) {
         rangeCheckForAdd(index);

         ensureCapacityInternal(size + 1);  // Increments modCount!!
         System.arraycopy(elementData, index, elementData, index + 1,
         size - index);
         elementData[index] = element;
         size++;
         }
         */
        arrayList.remove(1);
        /**
         * public E remove(int index) {
         rangeCheck(index);
         modCount++;
         E oldValue = elementData(index);
         int numMoved = size - index - 1;
         if (numMoved > 0)
         System.arraycopy(elementData, index+1, elementData, index, numMoved);
         elementData[--size] = null; //清除该位置的引用，让GC起作用
         return oldValue;
         }
         */
        System.out.println(arrayList);
    }
}
