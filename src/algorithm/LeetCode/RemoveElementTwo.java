package algorithm.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveElementTwo {
    public int removeIntTwo(List giveInt, int gNum){
        int resInt=0;
        for (int i=0;i<giveInt.size();i++){
            if (giveInt.get(i)==Integer.valueOf(gNum))
                giveInt.remove(giveInt.get(i));
            resInt++;
        }

        return giveInt.size()-resInt;
    }
    public static void main(String[] args){
        List<Integer> list=new ArrayList<Integer>();
        list.addAll(Arrays.asList(1,2,3,4,5,6,7,2,2,3,3,3,3,3,3));
        RemoveElementTwo removeElementTwo=new RemoveElementTwo();
        System.out.println(removeElementTwo.removeIntTwo(list,2));
        System.out.println(list.size());
    }
}
