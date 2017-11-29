/*
I = 1;
V = 5;
X = 10;
L = 50;
C = 100;
D = 500;
M = 1000;
 */
public class IntegerToRoman {
    public static String reToman(int inteTest){
        if (inteTest<0||inteTest>3999)
            return null;
//        int[] fourNum=new int[4];
//        for (int i=0;i<4;i++){
//            fourNum[i]=inteTest%10;
//            inteTest=inteTest/10;
//        }
        String strTwo="";
        String [] symbol={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] value={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        for (int i=0;inteTest!=0;i++){
            while (inteTest>=value[i]){
                inteTest=inteTest-value[i];
                strTwo=strTwo+symbol[i];
            }
        }

//        if (fourNum[0]==)
        return strTwo;
    }
    public static void main(String[] args){
        System.out.println(reToman(3888));
    }


}
