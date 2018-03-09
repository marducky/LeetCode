package majors.spring4.AxeDemo;

/**
 * @project: majors.spring4.Axe
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/03/09 17:08
 **/
public class BeanTest {
    public static void main(String[] args) {
        Chinese p = new Chinese(new SteelAxe());
        StoneAxe axe = new StoneAxe();
        p.setAxe(axe);
        p.useAxe();
    }
}
