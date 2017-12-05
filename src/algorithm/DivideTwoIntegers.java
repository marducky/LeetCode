package algorithm;

public class DivideTwoIntegers {
    public int divedeTwo(int devideIntOne,int devideIntTwo){
        int resInt=0;
        boolean zfFlag=true;
        if ((devideIntOne<0&&devideIntTwo>0)||devideIntOne>0&&devideIntTwo<0)
            zfFlag=false;
        devideIntOne=Math.abs(devideIntOne);
        devideIntTwo=Math.abs(devideIntTwo);
        if (devideIntOne>devideIntTwo)
            return 0;
        int sunNum=devideIntTwo-devideIntOne;
        while (sunNum>=0){
            resInt++;
            sunNum=sunNum-devideIntOne;
        }
        return zfFlag?resInt:(0-resInt);
    }
    public static void main(String[] args){
        DivideTwoIntegers divideTwoIntegers=new DivideTwoIntegers();
        System.out.println(divideTwoIntegers.divedeTwo(4,-270));
    }
}
