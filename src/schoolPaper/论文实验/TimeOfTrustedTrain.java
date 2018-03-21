package schoolPaper.论文实验;

import java.util.Random;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/03/21 15:30
 **/
public class TimeOfTrustedTrain {
    private static void printTimeOfVM(int n) {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            System.out.println((float) (49 + random.nextInt(6)) / 10);
        }
    }

    public static void main(String[] args) {
        printTimeOfVM(40);

    }
}
