package algorithm.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SearchForARangeTwo {
    public int[] findStartEnd(int[] num,int target){
        int[] resNum=new int[2];
        boolean flag=false;
        int gLen=num.length;
        Map<Integer,Integer> map=new HashMap<Integer, Integer>();
        for (int i=0;i<gLen-1;i++){
            if (num[0]==target)
                map.put(1,0);
            if (num[num.length-1]==target)
                map.put(2,num.length-1);
            if (num[i]!=target&&num[i+1]==target){
                map.put(1,i+1);
                //TODO:the next step to make the code done.
            }
            if (num[i]==target&&num[i+1]!=target){
                map.put(2,i);
                break;
            }
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
        if (!map.containsKey(1)&&!map.containsKey(2)){
            resNum[0]=-1;
            resNum[1]=-1;
        }
//        System.out.println(map.get(1).getClass().getName());
//        System.out.println(Integer.valueOf(map.get(1)).getClass().getName());
//        System.out.print(Arrays.toString(resNum));
        return resNum;
    }
    public static void main(String[] args){
        SearchForARangeTwo searchForARange=new SearchForARangeTwo();
        int[] giveNum={5,6,6,6,6,6,6,6,6,6,6,6,6,6,6,7,8,9,10};
        System.out.println(Arrays.toString(searchForARange.findStartEnd(giveNum,6)));
    }
}
