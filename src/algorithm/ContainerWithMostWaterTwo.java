package algorithm;

public class ContainerWithMostWaterTwo {
    public static int maxArea(int [] lengtHeitg){
        int left=0,right=lengtHeitg.length-1,maxArea=0;
        while (left<right){
            maxArea=Math.max(maxArea,Math.min(lengtHeitg[right],lengtHeitg[left])*(right-left));
            if (lengtHeitg[left]<lengtHeitg[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }
}
