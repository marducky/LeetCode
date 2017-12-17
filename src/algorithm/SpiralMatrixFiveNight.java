/**
 * For example,
 Given n = 3,

 You should return the following matrix:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]
 */
package algorithm;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Arrays;

public class SpiralMatrixFiveNight {
    public int[][] generateMatrix(int n) {
        int[][] resInt=returnRount(n);
        while (n>0){
//            n=returnRount(n).length;
//            for ()
        }
return null;
    }
    public int[][] returnRount(int n){
        int[][] ints=new int[n][n];
        if (n==0){
            ints[0][0]=0;
        }
        for (int i=0;i<n;i++){
            ints[0][i]=i+1;
        }
        for (int i=1;i<n-1;i++){
            ints[i][n-1]=n+i;
        }
        for (int i=n-1;i>=0;i--){
            ints[n-1][i]=n+n-2+(n-i);
        }
        for (int i=n-2;i>0;i--){
            ints[i][0]=n+n+n-2+(n-i-1);
        }
        return ints;
    }
    public static void main(String[] args){
        SpiralMatrixFiveNight spiralMatrixFiveNight=new SpiralMatrixFiveNight();
        for (int [] intTemp:spiralMatrixFiveNight.returnRount(2)){
            System.out.println(Arrays.toString(intTemp));}

    }
}
