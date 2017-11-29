import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

public class MedianofTwoSortedArraysFour {
    public static double findMedianSortedArrays(int num1[], int num2[]) {
        int[] num3=new int[num1.length+num2.length];
        int j=0;
        for (int k=0;k<num1.length;k++)
            num3[k]=num1[k];
        System.out.println(Arrays.toString(num1));
        System.out.println(Arrays.toString(num2));
        for (int i=num1.length;i<num1.length+num2.length;i++){
            num3[i]=num2[j];
            j++;}
        System.out.println(Arrays.toString(num3));
        int[] num4=bubbleSort1(num3,num3.length);
        System.out.println(Arrays.toString(num4));
        if (num4.length%2==0)
        {
            System.out.println(num4.length);
            return (double)(num4[num4.length/2]+num4[num4.length/2+1])/2;
        }
        else return num4[num4.length/2+1];
        }


    public static int[] bubbleSort1(int[] a, int n) {
        int i,j;
        for (i=n-1; i>0; i--) {
            // 将a[0...i]中最大的数据放在末尾
            for (j=0; j<i; j++) {
                if (a[j] > a[j+1]) {
                    // 交换a[j]和a[j+1]
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
        }
        return a;
    }
    public static void main(String[] args){
        int[] num5={1,2,3,4,5,6,7};
        int[] num6={8,9,10,11,12,13,14};
        System.out.println(findMedianSortedArrays(num5,num6));
    }

}
