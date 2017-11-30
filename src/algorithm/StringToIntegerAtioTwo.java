package algorithm;

public class StringToIntegerAtioTwo {
    public static int aoti(String strTwo){
        if (strTwo==null)
            return 0;
        strTwo=strTwo.trim();
        if (strTwo.length()==0)
            return 0;
        boolean fZPlus=false;
        int i=0;
        if (strTwo.charAt(0)=='-'||strTwo.charAt(0)=='+'){

            i++;
            if (strTwo.charAt(0)=='-')
                fZPlus=true;
        }
        int res=0;
        while (i<strTwo.length()){
            if (strTwo.charAt(i)<'0'||strTwo.charAt(i)>'9')
                break;
            int digit=(int)(strTwo.charAt(i)-'0');
            if (fZPlus&&res>-(Integer.MIN_VALUE-digit)/10)
                return Integer.MIN_VALUE;
            else if (!fZPlus&&res>(Integer.MAX_VALUE-digit)/10)
                return Integer.MAX_VALUE;
            res=res*10+digit;
            i++;
        }
        return fZPlus?res:-res;
    }
    public static void main(String[] args){
        System.out.println(aoti(" -123fg"));
        System.out.println(aoti(" +123fg"));
        System.out.println(aoti(" -1d23fg"));
        System.out.println(aoti(" +1d23fg"));
        System.out.println(aoti(" +122222222222d23fg"));
        System.out.println(aoti(" -122222222222d23fg"));


    }
}
