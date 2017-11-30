package algorithm;

import java.util.HashMap;
import java.util.Map;

public class RomanToIntegerThree {
    public static int toInt(String strThree){
        if (strThree.length()==0||strThree==null)
            return 0;
        int integer=0;
        Map<Character,Integer> map=new HashMap<Character, Integer>();
        int[] value={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        int[] valueTwo={1000,500,100,50,10,5,1};
        String [] symbol={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String symbolTwo="MDCLXVI";
        for (int i=0;i < valueTwo.length;i++){
            map.put(symbolTwo.charAt(i),valueTwo[i]);
        }
        integer=map.get(strThree.charAt(strThree.length()-1));
        for (int i=strThree.length()-2;i>=0;i--){
            if (map.get(strThree.charAt(i+1))>map.get(strThree.charAt(i))){
            integer=integer-map.get(strThree.charAt(i));
            }else integer=integer+map.get(strThree.charAt(i));
//            System.out.println("value(: "+i+") "+map.get(strThree.charAt(i)));
//            System.out.println("value(integer)"+integer);
        }
//        integer=integer+map.get(strThree.charAt(0));
//        System.out.println(map.get(strThree.charAt(0)));
        return integer;
    }
    public static void main(String[] args){
//        System.out.println(toInt("MMM"));
//        System.out.println(toInt("MMMDCCCLXXXVIII"));

//        System.out.println("IntegerToRoman: ");
//        System.out.println(IntegerToRomanTwo.intToRoman(31234));
        System.out.println(toInt(IntegerToRomanTwo.intToRoman(3214)));
    }
}
