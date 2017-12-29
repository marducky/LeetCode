/**
 * Restore IP Addresses
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * <p>
 * For example:
 * Given "25525511135",
 * <p>
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
package algorithm;

import java.util.ArrayList;
import java.util.Arrays;


public class RestoreIPAddresses {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> stringArrayList = new ArrayList<String>();
        return stringArrayList;
    }

    public ArrayList<int[]> changeInN(int n) {
        ArrayList<int[]> arrayList = new ArrayList<int[]>();
        //0<=n<=8
//        int zeroCount=0;
        int oneCount = 0;//()
        int twoCount = 0;//Max[0,(n-4)],n/2
        for (int i = Math.max(0, n - 4); i <= (n / 2); i++) {
            twoCount = i;
            oneCount = (n - (2 * i));
            if ((twoCount + oneCount) <= 4) {
                int[] tempInt = {twoCount, oneCount, (4 - (twoCount + oneCount))};
                arrayList.add(tempInt);
            }
        }
        return arrayList;
    }
    public ArrayList<int[]> OnTwZeADD(ArrayList<int[]> arrayList){
        ArrayList<int[]> arrayListTemp=new ArrayList<int[]>();
        for (int i=0;i<arrayList.size();i++){

            int[] tempInts=new int[4];
            for (int j=0;j<arrayList.get(i)[0];j++){
                tempInts[j]=2+1;
            }
            for (int j=0;j<arrayList.get(i)[1];j++){
                tempInts[arrayList.get(i)[0]+j]=1+1;
            }
            for (int j=0;j<arrayList.get(i)[2];j++){
                tempInts[arrayList.get(i)[0]+arrayList.get(i)[1]+j]=0+1;
            }
            arrayListTemp.add(tempInts);
        }
        return arrayListTemp;
    }

    public static void main(String[] args) {
        ArrayList<int[]> arrayList = new ArrayList<int[]>();
        ArrayList<int[]> arrayListTemp = new ArrayList<int[]>();
        RestoreIPAddresses restoreIPAddresses = new RestoreIPAddresses();
        for (int i = 0; i <= 8; i++) {
            arrayList = restoreIPAddresses.changeInN(i);
            arrayListTemp=restoreIPAddresses.OnTwZeADD(arrayList);
//            System.out.println("-----------");
//            System.out.println("IP ADD :  "+i);
//            for (int[] tempInts : arrayList) {
//                System.out.println(Arrays.toString(tempInts));
////                System.out.println(Arrays.toString(tempInts));
//            }
            for (int[] tempIntTemp:arrayListTemp){
                System.out.println(Arrays.toString(tempIntTemp));
//                System.out.println(Arrays.toString(tempIntTemp));
            }
        }
    }
}
