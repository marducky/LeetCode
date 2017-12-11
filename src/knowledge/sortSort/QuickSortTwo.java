package knowledge.sortSort;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class QuickSortTwo {
    private static int form=1;
    public static void quickSort(int[] a, int l, int r) {
        form++;
        if (l<r){
            int i,j,x;
            i=l;
            j=r;
            x=a[i];
            while (i<j){
                while (i<j&&a[j]>x){
                    j--;

                }
                if (i<j)
                    a[i++]=a[j];
                while (i<j&&a[i]<x)
                    i++;
                if (i<j)
                    a[j--]=a[i];
            }
            a[i]=x;
            quickSort(a,l,i-1);
            quickSort(a,i+1,r);
        }


    }

    public static void main(String[] args) {
        int i;
        int a[] = {30,40,60,10,20,50,100,10,15,10,10,10,10,100};

        System.out.printf("before sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        quickSort(a, 0, a.length-1);

        System.out.printf("after  sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
        System.out.printf("the cycle times is %d\n",form);
    }
}
