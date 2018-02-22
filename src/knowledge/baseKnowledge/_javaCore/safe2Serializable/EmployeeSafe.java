package knowledge.baseKnowledge._javaCore.safe2Serializable;

import java.io.Serializable;

/**
 * @project: knowledge.baseKnowledge._javaCore.safe2Serializable
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/22 15:44
 **/
public class EmployeeSafe implements Serializable {
    public String name;
    public String identify;

    public void mailCheck() {
        System.out.println("This is the " + this.identify + " of our company");
    }

}
