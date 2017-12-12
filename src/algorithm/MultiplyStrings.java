package algorithm;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        String resStr="";
        if (num1=="0"||num2=="0")
            return "0";
        int intNum1=strToInt(num1);
        int intNum2=strToInt(num2);
        int product=intNum1*intNum2;
        resStr=intToStr(product);
        return resStr;
    }
    public int strToInt(String numStrDemom){
        int resInt=0;
        int resTenInt=1;
        for (int i=numStrDemom.length()-1;i>=0;i--){
            int iTemp=numStrDemom.charAt(i)-'0';
            resInt=resInt+iTemp*resTenInt;
            resTenInt=10*resTenInt;
        }
        return resInt;
    }
    public String intToStr(int numIntRes){
        String resStr="";
        int lastInt=0;
//        int giveUpLastInt=0;
        while (numIntRes!=0){
            lastInt=numIntRes%10;
            resStr=resStr+(char)(lastInt+'0');
            numIntRes=numIntRes/10;
        }
        String chageRseStr="";
        for (int i=resStr.length()-1;i>=0;i--)
            chageRseStr+=resStr.charAt(i);
        return chageRseStr;
    }
    public static void main(String[] args){
        MultiplyStrings multiplyStrings=new MultiplyStrings();
        System.out.print(multiplyStrings.multiply("112","23"));
    }
}
