package algorithm;

import java.util.Arrays;

public class ZigZagConversion {
    public static String convert(String s, int nRows) {
        int len = s.length();
        if (len == 0 || nRows <= 1) return s;

        String[] ans = new String[nRows];
        Arrays.fill(ans, "");
        int row = 0, delta = 1;
        for (int i = 0; i < len; i++) {
            ans[row] += s.charAt(i);
            row += delta;
            if (row >= nRows) {
                row = nRows - 2;
                delta = -1;
            }
            if (row < 0) {
                row = 1;
                delta = 1;
            }
        }

        String ret = "";
        for (int i = 0; i < nRows; i++) {
            ret += ans[i];
        }
        return ret;
    }

    public static String convertTwo(String sTwo, int nRowsTwo) {
        int sLen = sTwo.length();//字符长度
//        int bLen = sLen / (2 * nRowsTwo - 2);//倍数
        int bLen = 0;//倍数
        int yLen = sLen % (2 * nRowsTwo - 2);//余数
        if (yLen==0)
            bLen=sLen / (2 * nRowsTwo - 2);
        else bLen=sLen / (2 * nRowsTwo - 2)+1;
        int maxLen=(nRowsTwo-1)*bLen;
        String[][] stRing=new String[nRowsTwo][bLen];
        for (int i=0;i<bLen;i++){
        }
        return null;
    }
    public static String convertThree(String sThree, int nRowsThree) {
        int sLen=sThree.length();
        int bLen = 0;//倍数
        int yLen = sLen % (2 * nRowsThree - 2);//余数
        if (yLen==0)
            bLen=sLen / (2 * nRowsThree - 2);
        else bLen=sLen / (2 * nRowsThree - 2)+1;
        String strings="";
//        for (int i=0;i<nRowsThree;i++){
//            if (i==0||i==nRowsThree-1)
//                strings+=i+2*nRowsThree-2;
//            else {
//                strings+=i+2*nRowsThree-2;
//            }
//        }
        for (int i=0;i<bLen;i++)
            strings+=sThree.charAt((2*nRowsThree-2)*i);
        System.out.println(strings);
        if (nRowsThree>2) {
            for (int k = 1; k < nRowsThree; k++) {
                for (int i = 0; i < bLen; i++) {
                    strings += sThree.charAt(i + (2 * nRowsThree - 2) * i);
                    strings += sThree.charAt(i + (2 * (nRowsThree - i)));
                }
            }
        }
        if (nRowsThree>2)
            for (int i=0;i<bLen;i++)
                strings+=sThree.charAt(nRowsThree-1+(2*nRowsThree-2)*i);
        return strings;
    }
    public static void main(String[] agrs) {
        String sTest = "qazxswedcvfrtgb";
        int nRowTest = 3;
        System.out.println(convert(sTest,nRowTest));
        System.out.println(convertThree(sTest,nRowTest));
    }
}

