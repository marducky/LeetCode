//55
/**
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 */
package algorithm.LeetCode;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int giveNumLen = nums.length;
        int nowLocation = 0;
        while (nowLocation < giveNumLen-1) {
//            nowLocation = nowLocation + nums[nowLocation];
            if (nowLocation==giveNumLen-1)
                return true;
            if (nums[nowLocation] == 0 && (nowLocation < giveNumLen - 1))
                return false;
            nowLocation = nowLocation + nums[nowLocation];
        }
        if (nowLocation < giveNumLen - 1)
            return false;
        if (nowLocation > giveNumLen - 1)
            return false;
        return true;
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        int[] giveNums = {1,1,1,1,1,1,0};
        int[] giveNums1 = {2, 3, 1, 1, 4};
        int[] giveNums2 = {3, 2, 1, 0, 4};

        int[] giveNums3 = {1,2,33,44};
        int[] giveNums4 = {2,2,2,2,22,2,2,2,1,1,1,1,1,1,0};
        int[] giveNums5 = {1,11,1,1,1,1,1,1,1,1,1,1,1,1,6,1,1,1,0};

        System.out.println(jumpGame.canJump(giveNums));
        System.out.println(jumpGame.canJump(giveNums1));
        System.out.println(jumpGame.canJump(giveNums2));
        System.out.println(jumpGame.canJump(giveNums3));
        System.out.println(jumpGame.canJump(giveNums4));
        System.out.println(jumpGame.canJump(giveNums5));
    }
}
