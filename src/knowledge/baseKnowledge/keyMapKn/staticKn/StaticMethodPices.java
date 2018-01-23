//在执行开始，先要寻找到main方法，因为main方法是程序的入口，但是在执行main方法之前，必须先加载Test类，而在加载Test类的时候发现Test类继承自Base类，因此会转去先加载Base类，在加载Base类的时候，发现有static块，便执行了static块。在Base类加载完成之后，便继续加载Test类，然后发现Test类中也有static块，便执行static块。在加载完所需的类之后，便开始执行main方法。在main方法中执行new Test()的时候会先调用父类的构造器，然后再调用自身的构造器。因此，便出现了上面的输出结果
package knowledge.baseKnowledge.keyMapKn.staticKn;

import java.sql.Date;

public class StaticMethodPices {
    private Date birthDate;
    private static Date startDate, endDate;

    static {
        startDate = Date.valueOf("1946");
        endDate = Date.valueOf("1948");
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isGieveDate() {
        return birthDate.compareTo(startDate) >= 0 && birthDate.compareTo(endDate) <= 0;
    }

    public static void main(String[] args) {
        StaticMethodPices staticMethodPices = new StaticMethodPices();
        staticMethodPices.setBirthDate(Date.valueOf("1949"));
        System.out.println(staticMethodPices.isGieveDate());
        StaticMethodPices staticMethodPices1 = new StaticMethodPices();
        staticMethodPices1.setBirthDate(Date.valueOf("1947"));
        System.out.println(staticMethodPices1.isGieveDate());
    }
}
