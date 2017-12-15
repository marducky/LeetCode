package knowledge.nowcoder;

public class BooleanTwo {
    Boolean flag=false;
    int p=2;
    public void bllo(){
        if (flag==false){
            System.out.print("Flase");
        }
        else {
            System.out.print("true");
        }
    }
    public static void main(String[] args){
        BooleanTwo booleanTwo=new BooleanTwo();
        booleanTwo.bllo();
    }
}
