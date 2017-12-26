/**
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.

 For example,
 Given heights = [2,1,5,6,2,3],
 return 10.
 */
package algorithm;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int resIntMan=0;
        for (int i=0;i<heights.length;i++){
            int[] resIntRet=findMinMax(heights,i);
            if ((resIntRet[1]-resIntRet[0])*heights[i]>resIntMan){
                resIntMan=(resIntRet[1]-resIntRet[0])*heights[i];
            }
        }
        return resIntMan;
    }
    public int[] findMinMax(int[] heights,int k){
        int[] resInts=new int[2];
        for (int i=k-1;i>=0;i--){
            if (heights[i]<heights[k])
            {
                resInts[0]=i;
                break;
            }
        }
        for (int i=k+1;i<heights.length;i++){
            if (heights[i]<heights[k]){
                resInts[1]=i-1;
                break;
            }
        }
        if (resInts[1]==0){
            resInts[1]=k;
        }
        return resInts;
    }
    public static void main(String[] args){
        LargestRectangleInHistogram largestRectangleInHistogram=new LargestRectangleInHistogram();
        int[] ints={2,1,5,6,2,3,7,7,7,7,7};
        System.out.println(largestRectangleInHistogram.largestRectangleArea(ints));
    }
}
