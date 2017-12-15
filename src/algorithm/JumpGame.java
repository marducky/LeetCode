//55
/**
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 */
package algorithm;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int giveNumLen = nums.length;
        int nowLocation = 0;
        while (nowLocation < giveNumLen-1) {
//            nowLocation = nowLocation + nums[nowLocation];
            if (nums[nowLocation] == 0 && (nowLocation < giveNumLen - 1))
                return false;
            nowLocation = nowLocation + nums[nowLocation];
        }
        if (nowLocation < giveNumLen - 1)
            return false;
        return true;
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        int[] giveNums1 = {2, 3, 1, 1, 4};
        int[] giveNums2 = {3, 2, 1, 0, 4};
        int[] giveNums = {1,1,1,1,1,1,0};
        System.out.print(jumpGame.canJump(giveNums));
    }
}
