package algorithm;

public class RomanToInteger {
    public static int toInteger(String strOne){
        int strLen=strOne.length();
        int integer=0;
        int[] value={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        int[] valueTwo={1000,500,100,50,10,5,1};
        String [] symbol={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String symbolTwo="MDCLXVI";

        for (int i=0;i<strLen-1;i++){
            for (int j=0;j<valueTwo.length;j++){
                if (strOne.charAt(i)==symbolTwo.charAt(j))
                    if (valueTwo[i]<valueTwo[i+1]){
                    integer=integer+valueTwo[j];
                }
                else
                    integer=integer-valueTwo[j];
            }
        }
        return integer;
    }
    public static void main(String[] args){
        System.out.println(toInteger("MMMDCCCLXXXVIII"));
    }
}
