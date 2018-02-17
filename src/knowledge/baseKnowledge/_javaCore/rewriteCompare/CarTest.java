package knowledge.baseKnowledge._javaCore.rewriteCompare;


import java.util.Arrays;
import java.util.Scanner;

public class CarTest {


    public static void change() {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.println("1:按编号排序2：按价格排序3：按牌子排序4：按销售量排序");
        System.out.println("请选择：");
        n = scanner.nextInt();
        switch (n) {
            case 1:
                Car.SortFiled = Car.STRNO;
                comm();
                break;
            case 2:
                Car.SortFiled = Car.PRICE;
                comm();
                break;
            case 3:
                Car.SortFiled = Car.STRNAME;
                comm();
                break;
            case 4:
                Car.SortFiled = Car.SALE;
                comm();
                break;
            default:
                break;
        }
    }

    public void start() {
        System.out.println("-------------------欢迎进入汽车排序系统--------------------");
        change();
    }

    public static void comm() {
        Car car1 = new Car(1001l, "aodi", 230000, 330);
        Car car2 = new Car(1002l, "xiandai", 150000, 900);
        Car car3 = new Car(1003l, "dazhong", 130000, 450);
        Car car4 = new Car(1004l, "xiaokang", 73000, 740);
        Car car5 = new Car(1005l, "baoma", 690000, 30);
        Car[] cars = {car1, car2, car3, car4, car5};
        Arrays.sort(cars);


        for (Car car : cars) {
            System.out.println("编号:" + car.getStrNo() + "\t|" + "品牌：" + car.getStrName() + "\t|" + "价格：" + car.getPrice() + "\t|" + "销售：" + car.getSale());
        }
    }

    public static void main(String[] args) {
        CarTest t = new CarTest();
        t.start();
    }


}

