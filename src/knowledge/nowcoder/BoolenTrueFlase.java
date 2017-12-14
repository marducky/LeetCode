package knowledge.nowcoder;

public class BoolenTrueFlase {
    public static void main(String[] args){
        System.out.print(true?false:true==true?false:true);
        //==等级高于三目运算符
        //so first to verify the true==true(true)
        //step1：true?false:true?false:true
        //三目运算符从右向左执行
        //true?false:true==false
        //step2：true?false:false
        //step==false
    }
}
