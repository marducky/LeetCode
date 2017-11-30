package algorithm;

import java.util.HashMap;

public class ThreeSumMy {
    public static int[] sortNb(int[] nb){
        int temp=0;
        for (int i=nb.length-1;i>=0;i--){
            for (int j=i;j>0;j--)
                if (nb[j]<nb[j-1]){
                    temp=nb[j];
                    nb[j]=nb[j-1];
                    nb[j-1]=temp;
            }
        }
        return nb;
    }
    public static boolean threeSum(int[] nb,int tg){
        int[] res=new int[3];
        if (nb==null||nb.length<3)
            return false;
        HashMap<String,Integer> map1=new HashMap<String, Integer>();
        for (int i=0;i<nb.length;i++){
            for (int j=i+1;j<nb.length;j++)
                map1.put(Integer.toString(i)+Integer.toString(j),nb[i]+nb[j]);
        }
        for (int i=0;i<nb.length;i++)
            if (map1.containsValue(tg-nb[i]))
                return true;
        return false;
    }
    public static void main(String[] args){
        int[] xx={2,4,1,5,9,6,7};
        int[] xxx=sortNb(xx);
        for (int x:xxx)
            System.out.print(x);
        System.out.println(threeSum(xxx,55));
    }
}
