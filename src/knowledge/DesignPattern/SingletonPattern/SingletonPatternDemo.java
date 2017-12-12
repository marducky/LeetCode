package knowledge.DesignPattern.SingletonPattern;

public class SingletonPatternDemo {
    public static void main(String[] args){
        //不合法的构造函数
        //编译时错误：构造函数 single
        SingleObject object=SingleObject.getInstance();
        object.showMessage();
    }
}
