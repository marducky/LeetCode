package majors.spring4.AxeDemo;

/**
 * @project: majors.spring4.Axe
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/03/09 17:07
 **/
public class Chinese implements Person {
    private Axe axeDemo;

    public void setAxe(Axe axe) {
        this.axeDemo = axe;
    }

    public Chinese(Axe axeDemo) {
        this.axeDemo = axeDemo;
    }

    @Override
    public void useAxe() {
        System.out.println("我打算去砍点柴火");
        System.out.println(axeDemo.chop());
    }
}
