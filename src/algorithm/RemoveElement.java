package algorithm;

public class RemoveElement {
    public int removeInt(int[] giveInt,int gNum){
        int resInt=0;
        for (int i=0;i<giveInt.length;i++){
            if (giveInt[i]!=gNum)
                resInt++;
        }
        return resInt;
    }
    public static void main(String[] args){
        int[] ints={1,2,3,4,5,6,2,3,4};
        RemoveElement removeElement=new RemoveElement();
        System.out.println(removeElement.removeInt(ints,2));
        System.out.println(ints.length);
    }
}
