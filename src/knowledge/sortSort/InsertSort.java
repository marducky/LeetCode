package knowledge.sortSort;

import java.util.Arrays;

public class InsertSort {
    public static void instertSort(int[] giveNum){
        for (int i=1;i<giveNum.length;i++){
            int k=1;
            for (int j=0;j<i;j++){
                if (giveNum[i]<giveNum[j]){
                    k=j;
                    for (int g=i;g>k;g--){
                         giveNum[g]=giveNum[g-1];
                    }
                }
            }
            giveNum[k]=giveNum[i];
        }
    }
    public static void insertSortTwo(int[] a, int n) {
        int i, j, k;

        for (i = 1; i < n; i++) {

            //为a[i]在前面的a[0...i-1]有序区间中找一个合适的位置
            for (j = i - 1; j >= 0; j--)
                if (a[j] < a[i])
                    break;

            //如找到了一个合适的位置
            if (j != i - 1) {
                //将比a[i]大的数据向后移
                int temp = a[i];
                for (k = i - 1; k > j; k--)
                    a[k + 1] = a[k];
                //将a[i]放到正确位置上
                a[k + 1] = temp;
            }
        }
    }
    public static void main(String[] args){
        int[] ints={1,3,2,6,4,2};
//        instertSort(ints);
        insertSortTwo(ints,6);
        System.out.print(Arrays.toString(ints));
    }
}
