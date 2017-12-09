package algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SearchForARange {
    public int[] findStartEnd(int[] num,int target){
        int[] resNum=new int[2];

        int gLen=num.length;
        Map<Integer,Integer> map=new HashMap<Integer, Integer>();
        for (int i=0;i<gLen;i++){
            if (num[i]==target)
                if (map.isEmpty())
                    map.put(1,i);
                else
                    if (!map.containsKey(2))
                        map.put(2,i);
                    else
                        map.replace(2,i);
        }
        if (map.containsKey(1)&&map.containsKey(2))
        {
            resNum[0]=Integer.valueOf(map.get(1));
            resNum[1]=map.get(2);
        }
        if (map.containsKey(1)&&!map.containsKey(2)){
            resNum[0]=map.get(1);
            resNum[1]=-1;
        }
        if (map.containsKey(1)&&!map.containsKey(2)){
            resNum[0]=-1;
            resNum[1]=-1;
        }
//        System.out.println(map.get(1).getClass().getName());
//        System.out.println(Integer.valueOf(map.get(1)).getClass().getName());
//        System.out.print(Arrays.toString(resNum));
        return resNum;
    }
    public static void main(String[] args){
        SearchForARange searchForARange=new SearchForARange();
        int[] giveNum={1,2,3,4,5,6,6,6,6,8,9,10};
        System.out.println(Arrays.toString(searchForARange.findStartEnd(giveNum,6)));
    }
}
