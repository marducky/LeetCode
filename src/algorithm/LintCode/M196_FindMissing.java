package algorithm.LintCode;

import java.util.Arrays;

/**
 * @project: algorithm.LintCode
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/22 14:25
 **/
public class M196_FindMissing {
    /**
     * @param nums: An array of integers
     * @return: An integer
     */
    public int findMissing(int[] nums) {
        // write your code here
//       List list= Arrays.asList(nums);
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if ((nums[i + 1] - nums[i]) != 1) {
//               return nums[i+1];
                result = nums[i + 1] - 1;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        M196_FindMissing findMissing = new M196_FindMissing();
        int n[] = {1, 3, 4, 5, 6, 7};
        System.out.println(findMissing.findMissing(n));

    }
}
