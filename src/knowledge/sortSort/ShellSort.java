package knowledge.sortSort;

public class ShellSort {
    public static void shellSort1(int[] a,int n){
        for (int gap=n/2;gap>0;gap/=2){
            for (int i=0;i<gap;i++){
                for (int j=i+gap;j<n;j+=gap){
                    if (a[j]<a[j-gap]){
                        int tmp=a[j];
                        int k=j-gap;
                        while (k>=0&&a[k]>tmp){
                            a[k+gap]=a[k];
                            k-=gap;
                        }
                        a[k+gap]=tmp;
                    }
                }

            }
        }
    }
    public static void groupSort(int[] a, int n, int i,int gap) {

        for (int j = i + gap; j < n; j += gap) {

            // 如果a[j] < a[j-gap]，则寻找a[j]位置，并将后面数据的位置都后移。
            if (a[j] < a[j - gap]) {

                int tmp = a[j];
                int k = j - gap;
                while (k >= 0 && a[k] > tmp) {
                    a[k + gap] = a[k];
                    k -= gap;
                }
                a[k + gap] = tmp;
            }
        }
    }
    public static void shellSort2(int[] a, int n) {
        // gap为步长，每次减为原来的一半。
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // 共gap个组，对每一组都执行直接插入排序
            for (int i = 0 ;i < gap; i++)
                groupSort(a, n, i, gap);
        }
    }

    public static void main(String[] args) {
        int i;
        int a[] = {80,30,60,40,20,10,50,70};

        System.out.printf("before sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

//        shellSort1(a, a.length);
        shellSort2(a, a.length);

        System.out.printf("after  sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }
}
