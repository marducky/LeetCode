package algorithm;

import java.util.Arrays;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1, maxArea = 0;
        while(left < right){
            // 每次更新最大面积（盛水量）
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            // 如果左边较低，则将左边向中间移一点
            if(height[left] < height[right]){
                left++;
                // 如果右边较低，则将右边向中间移一点
            } else {
                right--;
            }
        }
        return maxArea;
    }
    public static void main(String[] args){
        int[] n={1,4,5,2,4,1,5,9,13};
        int maxAreaMaxn=maxArea(n);
        System.out.println(maxAreaMaxn);
    }
}
