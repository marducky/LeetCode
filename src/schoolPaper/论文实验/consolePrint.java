package schoolPaper.论文实验;

import java.util.Random;

/**
 * @project: schoolPaper.论文实验
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/03/08 13:05
 **/
public class consolePrint {
    public static void printUserForNormal() {
        System.out.println("root@k8s-node-1:~# ");
    }
    public static void printUserForNormal(int... args) {
        if (args[0] == 1) {
            System.out.println("janus@k8s-node-1:~$ ");
        } else if (args[0] == 2) {
            System.out.println("root@k8s-node-1:/home/janus# ");
        } else if (args[0] == 3) {

            System.out.println("root@k8s-node-1:~# ");
        } else if (args.length == 2) {
            System.out.println("root@k8s-node-1:/home/janus# cd ");
            System.out.println("root@k8s-node-1:~# ");
        } else if (args.length == 0) {
            System.out.println("root@k8s-node-1:~# ");
        }

    }

    public static void printUserForNormal(String command, int... args) {
        if (args[0] == 1) {
            System.out.println("janus@k8s-node-1:~$ " + command);
        } else if (args[0] == 2) {
            System.out.println("root@k8s-node-1:/home/janus# " + command);
        } else if (args[0] == 3) {
            System.out.println("root@k8s-node-1:~# " + command);
        } else {
            System.out.println("root@k8s-node-1:/home/janus# cd");
            System.out.println("root@k8s-node-1:~# " + command);
        }

    }

    public static void printHash(int... args) {
        if (args.length > 2) {
            return;
        }
        Random random = new Random();
        if (args.length == 1) {
            for (int i = 1; i <= args[0]; i++) {
                System.out.print("PCR[" + (i - 1) + "]: ");
                for (int k = 1; k < 41; k++) {
                    int num = random.nextInt(15);
                    System.out.print((Integer.toHexString(num)).toString().toUpperCase());
                    if ((k % 2 == 0)) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        } else if (args.length == 2) {
            for (int o = args[0]; o < args[1]; o++) {
//                System.out.println(String.format("%02d",o));
                System.out.print("PCR-" + String.format("%02d ", o - 1));
                for (int j = 1; j < 41; j++) {
                    int num = random.nextInt(15);
                    System.out.print((Integer.toHexString(num) + "").toLowerCase().toUpperCase());
                    if ((j % 2 == 0)) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        } else {
            System.out.print("PCR[" + (0) + "]: ");
            for (int j = 1; j < 41; j++) {

                int num = random.nextInt(15);
                System.out.print((Integer.toHexString(num) + "").toUpperCase());
                if ((j % 2 == 0)) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }




    }

    public static void main(String[] args) {
//        System.out.println("");
//        printUserForNormal(1);
//        printUserForNormal("ls",4);
//
//        printHash();
//        printHash(3);
        printHash(3, 8);
        printUserForNormal();
    }

}
