package knowledge.javaCore.javaCoreBookTwo.chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int i=0;
//        int[] ints=new int[10];
//        while (i<10){
//            ints[i]=scanner.nextInt();
//            i++;
//
//        }
        ArrayList<String> stringArrayList = new ArrayList<String>();
        while ((stringArrayList.size() < 10)) {
            String[] stringsTemp = scanner.nextLine().split(" ");
            for (String string : stringsTemp) {
                stringArrayList.add(string);
            }
        }
        System.out.println(Arrays.asList(stringArrayList));
//        System.out.println(Arrays.toString(ints));
    }
}
