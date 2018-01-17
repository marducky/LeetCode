/**
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
package algorithm.LeetCode;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int res=nums[0];
        for (int i=0;i<nums.length;i++){
            int tempRes=nums[i];
            for (int k=i+1;k<nums.length;k++){
                tempRes+=nums[k];
                if (tempRes>res)
                    res=tempRes;
            }
        }
        return res;
    }
    public static void main(String[] args){
        MaximumSubarray maximumSubarray=new MaximumSubarray();
        int[] nums1={1,2,3,4};
        int[] nums={-2,1,-3,4,-1,2,1,5,4};
        System.out.print(maximumSubarray.maxSubArray(nums));
    }
}
