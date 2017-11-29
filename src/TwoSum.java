import java.util.Arrays;
import java.util.HashMap;
public class TwoSum {

    public static int[] twoSum(int[] numbers, int target) {
        int[] res=new int[2];
        if (numbers==null||numbers.length<2)
            return null;
        HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
        for (int i=0;i<numbers.length;i++){
            if (map.containsKey(target-numbers[i])){
                res[0]=map.get(target-numbers[i])+1;
                res[1]=i+1;
                return res;
            }
            map.put(numbers[i],i);

        }

//        int[] res = new int[2];
//        if(numbers==null || numbers.length<2)
//            return null;
//        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
//        for(int i=0;i<numbers.length;i++)
//        {
//            if(map.containsKey(target-numbers[i]))
//            {
//                res[0]=map.get(target-numbers[i])+1;
//                res[1]=i+1;
//                return res;
//            }
//            map.put(numbers[i],i);
//        }
//        return null;
        return null;
    }
    public static void main(String[] agrs){
        int[] x={1,4,5,6,7};
        int target=5;
        int[] rrr=twoSum(x,target);
        System.out.println(Arrays.toString(rrr));
//        for (int i=0;i<rrr.length;i++){
//            System.out.println(rrr[i]);
//        }
    }
}
