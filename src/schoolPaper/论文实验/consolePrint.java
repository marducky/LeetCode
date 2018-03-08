package schoolPaper.论文实验;

/**
 * @project: schoolPaper.论文实验
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/03/08 13:05
 **/
public class consolePrint {
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

    public static void main(String[] args) {
//        System.out.println("");
//        printUserForNormal(1);
//        printUserForNormal("ls",4);
//
    }
}
