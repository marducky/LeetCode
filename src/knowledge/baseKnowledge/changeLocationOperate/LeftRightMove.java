package knowledge.baseKnowledge.changeLocationOperate;

public class LeftRightMove {
    public static void main(String[] args){
        int sss=12;
        System.out.println(sss);
        prinfInfo(sss);

        int sssMoveLeft=sss<<1;
        System.out.println(sssMoveLeft);
        prinfInfo(sssMoveLeft);


        int sssMoveRight=sss>>1;
        System.out.println(sssMoveRight);
        prinfInfo(sssMoveRight);
    }
    public static void prinfInfo(int num){
        System.out.println(Integer.toBinaryString(num));
    }
}
