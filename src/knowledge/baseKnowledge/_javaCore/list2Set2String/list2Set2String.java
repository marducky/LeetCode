//http://blog.csdn.net/my_precious/article/details/53010232
package knowledge.baseKnowledge._javaCore.list2Set2String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @project: knowledge.baseKnowledge._javaCore.list2Set2String
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/13 15:46
 **/
public class list2Set2String {
    public static void main(String[] args) {
        //数组转List
        String[] demoString = new String[]{"Janus", "Tomas", "Jack"};
        for (String s : demoString) {
            System.out.print(s + "-");

        }
        System.out.println();
        System.out.println("========数组转List========");
        List demoString2List = Arrays.asList(demoString);
        for (Object s : demoString2List) {
            System.out.print(s.toString() + "-");
        }
        System.out.println();
        //需要注意的是， Arrays.asList() 返回一个受指定数组决定的固定大小的列表。所以不能做 add 、 remove 等操作，否则会报错。
        System.out.println("========数组转Set========");
        Set<String> demoStringSet = new HashSet<>(Arrays.asList(demoString));
        for (String s : demoStringSet) {
            System.out.print(s + "-");
        }
        //set 可以add
        System.out.println();
        demoStringSet.add("AddName");
        for (String s : demoStringSet) {
            System.out.print(s + "-");
        }
        System.out.println();

    }
}
