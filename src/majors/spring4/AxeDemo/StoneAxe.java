package majors.spring4.AxeDemo;

/**
 * @project: majors.spring4.Axe
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/03/09 17:05
 **/
//斧头接口的一个实现
public class StoneAxe implements Axe {
    @Override
    public String chop() {
        return "石斧砍柴好慢";
    }
}
